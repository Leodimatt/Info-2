public class Sorting {
    public static void main(String[] args) {
        int[] toSort = new int[100];

        for(int i = 0; i < 100; i++) {
            toSort[i] = i+1;
        }

        for(int i = 99; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));

            int temp = toSort[i];
            toSort[i] = toSort[j];
            toSort[j] = temp;
        }


        System.out.println("Unsorted: ");
        for (int n: toSort) {
            System.out.print(n + " ");
        }
        System.out.println();

        bubbleSort(toSort);

        System.out.println("Sorted: ");
        for(int n: toSort) {
            System.out.print(n + " ");
        }
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void bubbleSort(int[] toSort) {
        boolean swapped;
        int m = toSort.length - 1;
        do {
            swapped = false;
            for(int i = 1; i <= m; i++) {
                if (toSort[i - 1] > toSort[i]) {
                    swap(toSort, i - 1, i);
                    swapped = true;
                }
            }
            m -= 1;
        }
        while (swapped);
    }

    public static void selectionSort(int[] toSort) {
        for (int i = 0; i <= toSort.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j <= toSort.length - 1; j++) {
                if(toSort[j] < toSort[min]) {
                    min = j;
                }
            }
            swap(toSort, i, min);
        }
    }
}
