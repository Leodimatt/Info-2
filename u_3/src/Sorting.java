public class Sorting {
    public static void main(String[] args) {
        Person[] toSort = {
                new Person("Anna", 30, "anna@example.com"),
                new Person("Ben", 25, "ben@example.com"),
                new Person("David", 28, "david@example.com"),
                new Person("Klara", 35, "klara@example.com"),
                new Person("Ela", 22, "ela@example.com")
        };

        // Shuffle
        for (int i = toSort.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Person temp = toSort[i];
            toSort[i] = toSort[j];
            toSort[j] = temp;
        }

        System.out.println("Unsorted:");
        for (Person p : toSort) {
            System.out.println(p);
        }

        // bubbleSort(toSort);
        selectionSort(toSort);

        System.out.println("\nSorted:");
        for (Person p : toSort) {
            System.out.println(p);
        }
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int pos1, int pos2) {
        // Eine temporäre variable mit dem element aus der ersten position initialisieren
        T temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;

        // Das ganze wäre auch mit einem one-liner möglich:

        // arr[pos1] = arr[pos1] ^ arr[pos2] ^ (arr[pos2] = arr[pos1])
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] toSort) {
        // Bubblesort nach Pseudocode

        boolean swapped;
        int m = toSort.length - 1;
        do {
            swapped = false;
            for (int i = 1; i <= m; i++) {
                if (toSort[i - 1].compareTo(toSort[i]) > 0) {
                    swap(toSort, i - 1, i);
                    swapped = true;
                }
            }
            m--;
        } while (swapped);
    }

    public static <T extends Comparable<T>> void selectionSort(T[] toSort) {
        // Selectionsort nach Pseudocode
        for (int i = 0; i < toSort.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < toSort.length; j++) {
                if (toSort[j].compareTo(toSort[min]) < 0) {
                    min = j;
                }
            }
            swap(toSort, i, min);
        }
    }
}
