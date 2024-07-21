public class QuickSort {

    // Main function that implements QuickSort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // pi is partitioning index, array[pi] is now at right place
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Function to take the last element as pivot, places the pivot element at its correct position
    // in sorted array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // A utility function to print array of size n
    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    // Main function to test the QuickSort
    public static void main(String[] args) {
        int[] array = {20, 8, 9, 6, 1, 3};
        int n = array.length;
        System.out.println("Given Array");
        printArray(array);

        quickSort(array, 0, n - 1);

        System.out.println("\nSorted array");
        printArray(array);
    }
}