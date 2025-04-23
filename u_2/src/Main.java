import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Array mit Werten in Mrikosekunden
        double[] zeiten = {
                1e6, // 1 Sekunde
                6e7, // 1 Minute
                3.6e9, // 1 Stunde
                8.64e10, // 1 Tag
                3.1536e13, // 1 Jahr
        };

        for (double z : zeiten) {
            System.out.println("Für t = " + (long) z + " Mikrosekunden:");

            // n log n
            long start = System.nanoTime();
            long nLogN = maxNLogN(z, true);
            long dauer = (System.nanoTime() - start) / 1000;
            System.out.println("  max n für n*log2(n) ≤ t: " + nLogN + " (Dauer: " + dauer + " µs)");

            // n!
            start = System.nanoTime();
            long nFac = maxNFac(z, false);
            dauer = (System.nanoTime() - start) / 1000;
            System.out.println("  max n für n! ≤ t: " + nFac + " (Dauer: " + dauer + " µs)");
            System.out.println();
        }
    }

    // Für die schnellere Variante geben wir als zweites Argument true
    private static long maxNLogN(double t, boolean useBinarySearch) {
        int n = 1;

        if(useBinarySearch) {
            System.out.println("Using Binary Search");
            long low = 1;
            long high = Integer.MAX_VALUE;
            long res = 0;


            // Wir suchen vorerst eine Obere Grenze
            while(high * log2(high) <= t && high < Integer.MAX_VALUE / 2) {
                high *= 2;
            }

            // Das hier ist der eigentliche "Binary Search"
            while(low <= high) {
                long mid = low + (high - low) / 2;
                double c = mid * log2(mid);

                if(c <= t) {
                    res = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return res;

        } else {
            while (true) {
                double result = n * log2(n);
                if (result > t) break;
                n++;
            }
        }
        return n - 1;
    }


    // Wenn wir useBigInt auf false setzen könnte es sein, dass die variable fac "overflowed", sprich der Wert ins negative geht, da er zu groß wird
    private static long maxNFac(double t, boolean useBigInt) {
        long n = 1;
        if(useBigInt) {
            System.out.println("Using Big Int");
            BigInteger fac = BigInteger.ONE;
            while (true) {
                fac = fac.multiply(BigInteger.valueOf(n));
                // Schätze die Zeit für die Berechnung von n!
                // Hier: n! ≤ t, also suche das größte n mit n! ≤ t
                if (fac.compareTo(BigInteger.valueOf((long) t)) > 0) {
                    return n - 1;
                }
                n++;
            }
        }
        // Ohne BigInteger
        else {
            long fac = 1;
            while (fac <= t) {
                n++;
                fac *= n;
                if(fac < 0) break;
            }
            return n - 1;
        }

    }

    // Hilfsmethode für log2
    private static double log2(long n) {
        return Math.log(n) / Math.log(2);
    }
}