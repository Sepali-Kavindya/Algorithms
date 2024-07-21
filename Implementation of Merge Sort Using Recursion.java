public class MergeSort {

    // Main function that sorts array[0..n-1] using mergeSort
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Split the array into two halves
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            // Recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted halves
            merge(array, left, right);
        }
    }

    // Function to merge two subarrays of array[].
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the temp arrays back into array[l..r]
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // A utility function to print array of size n
    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    // Main function to test the MergeSort
    public static void main(String[] args) {
        int[] array = {16, 13, 11, 8, 6, 7};
        System.out.println("Given Array");
        printArray(array);

        mergeSort(array);

        System.out.println("\nSorted array");
        printArray(array);
    }
}