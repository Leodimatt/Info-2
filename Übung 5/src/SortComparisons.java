import java.util.Random;
import java.util.Arrays;

public class SortComparisons {

    // implementierung von InsertionSort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // implementierung von mergeSort
    public static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) { // falls nur ein Element im Array ist muss nichts sortiert werden
            return;
        }
        int midIndex = inputLength / 2;
        // Teilarrays erstellen
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex]; // inputLength - midIndex falls Eingabearray ungerade länge hat

        for(int i = 0; i < midIndex; i++) { // leftHalf mit linker Hälfte der Elementen des Ursprungsarrays befüllen
            leftHalf[i] = inputArray[i];
        }
        for(int i = midIndex; i < inputLength; i++) { // rightHalf mit rechter Hälfte der Elementen des Ursprungsarrays befüllen
            rightHalf[i - midIndex] = inputArray[i];
        }
        mergeSort(leftHalf); // "conquer Teil"
        mergeSort(rightHalf); // "conquer Teil"
        merge(inputArray, leftHalf, rightHalf); // "Vereinigung - Teil"
    }

    public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if(leftHalf[i] <= rightHalf[j]) { // Vergleich der Elemente der Teilarrays
                inputArray[k] = leftHalf[i]; // kleineres Element zum Sortierten Endarray hinzufügen
                i++; // auf nächstes Element setzen
            }
            else {
                inputArray[k] = rightHalf[j]; // Wenn anderes Element größer ist, wird dieses hier hinzugefügt
                j++; // auf nächstes Element setzen
            }
            k++; // auf nächstes Element setzen
        }
        // Ersatz für Wächter; schaut, ob noch Elemente im Teilarray übrig sind
        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        // Ersatz für Wächter; schaut, ob noch Elemente im Teilarray übrig sind
        while (j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    // implementierung der hybridSort Methode
    private static final int SCHWELLWERT = 10; // Schwellwert für "kleine" Arrays

    public static void hybridSort(int[] array) {
        if (array.length <= SCHWELLWERT) {
            insertionSort(array); // InsertionSort für kleine Arrays
        } else {
            int mid = array.length / 2;

            // rekursive Aufteilung für hybridSort
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            hybridSort(left);
            hybridSort(right);

            merge(array, left, right);
        }
    }

    // zufällige Arrays werden erstellt
    public static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Werte zwischen 0 und 999
        }
        return array;
    }

    // Durchführung der Zeitmessung
    public static long measureTime(Runnable sortingMethod) {
        long startTime = System.nanoTime();
        sortingMethod.run();
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 1000, 10000}; // vorgegebene Array Größen
        int tests = 100; // Anzahl der Durchläufe pro Größe
        Random random = new Random(0); // random-Instanz

        System.out.println("Durchschnittliche Laufzeiten (in Millisekunden):");

        for (int size : sizes) {
            long insertionSortTime = 0;
            long mergeSortTime = 0;
            long hybridSortTime = 0;

            for (int t = 0; t < tests; t++) {
                // zufällige Arrays werden erzeugt
                int[] originalArray = generateRandomArray(size, random);

                // Messung von InsertionSort
                int[] arrayForInsertionSort = Arrays.copyOf(originalArray, originalArray.length);
                insertionSortTime += measureTime(() -> insertionSort(arrayForInsertionSort));

                // Messung von MergeSort
                int[] arrayForMergeSort = Arrays.copyOf(originalArray, originalArray.length);
                mergeSortTime += measureTime(() -> mergeSort(arrayForMergeSort));

                // Messung von hybridSort
                int[] arrayForHybridSort = Arrays.copyOf(originalArray, originalArray.length);
                hybridSortTime += measureTime(() -> hybridSort(arrayForHybridSort));
            }

            // Berechnung & Ausgabe der Durchschnittszeiten
            System.out.println("Arraygröße " + size + ":");
            System.out.printf("Insertionsort: %.2f ms%n", (insertionSortTime / tests) / 1_000_000.0);
            System.out.printf("Mergesort: %.2f ms%n", (mergeSortTime / tests) / 1_000_000.0);
            System.out.printf("HybridSort: %.2f ms%n", (hybridSortTime / tests) / 1_000_000.0);
        }
    }
}
