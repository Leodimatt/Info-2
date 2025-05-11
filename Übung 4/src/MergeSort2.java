import java.util.Arrays;

public class MergeSort2 {
    public static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create a copy of left and right subarrays
        T[] L = Arrays.copyOfRange(arr, left, mid + 1);
        T[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        // Assign our variables;
        int i = 0, j = 0;

        for (int k = left; k <= right; k++) {
            // Check if we are going out of bounds
            if (i < n1 && (j >= n2 || L[i].compareTo(R[j]) <= 0)) {
                arr[k] = L[i++];
            } else if (j < n2) {
                arr[k] = R[j++];
            }
        }
    }
    public static <T extends Comparable<T>> void sort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[100];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }
}
