import java.util.Arrays;

public class Quicksort {

    // Quicksort algorithm
    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int q = partition(arr, l, r);
            quicksort(arr, l, q - 1);
            quicksort(arr, q + 1, r);
        }
    }

    // Partition helper
    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    //swap elements helper
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                {},
                {5},
                {9, 3, 2, 1, 8},
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {3, 3, 3, 3, 3},
                {2, 41, 42, 26, 38, 99, 3}
        };

        for (int[] arr : testArrays) {
            quicksort(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
        }
    }
}
