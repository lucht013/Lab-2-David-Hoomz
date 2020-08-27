//Hoomz Damte   
import java.util.Arrays;

public class SortingMethods {
    /**
     * The method sorts an array using insertion sort
     *
     * @param <T> - the type of elements in the array (must extend Comparable<T>)
     * @param arr - the array to be sorted
     */
    // the method is static and sorts any data that implements Comparable
    // interface: String, Integer, Card (if implements Comparable<Card>
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {

        for (int i = 1; i < arr.length; ++i) {
            // loop invariant: arr[0..i-1] is sorted

            // the item to be inserted into the proper
            // position in the sorted portion of the array
            T nextItem = arr[i];

            // iterating through the sorted portion backward
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(nextItem) > 0) {
                // loop invariant: nextItem is smaller than
                // elements to the left of it

                //shift arr[j-1] to the right
                arr[j] = arr[j - 1];
                j--;
            }
            // insert the new item into its position
            arr[j] = nextItem;
        }
    }

    /**
     * The method takes an array and returns true if the array is in order (from lowest to highest)
     * and false otherwise. Allows repeated elements.
     *
     * @param arr - the array to be checked
     * @param <T> - the type of elements in the array (must extend Comparable<T>)
     * @return - a boolean that indicates whether the elements of the array are in order
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method sorts an array using merge sort. The method is recursive.
     *
     * @param <T> - the type of elements in the array (must extend Comparable<T>)
     * @param arr - the array to be sorted
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length > 1) {
            // split the array into two halves
            int length1 = arr.length / 2;
            int length2 = arr.length - arr.length / 2;


            // create the arrays:
            T[] half1 = (T[]) new Comparable[length1];
            T[] half2 = (T[]) new Comparable[length2];

            // copy the corresponding portions of the array into new arrays
            for (int i = 0; i < length1; i++) {
                half1[i] = arr[i];
            }

            for (int i = length1; i < arr.length; i++) {
                half2[i - length1] = arr[i];
            }

            mergeSort(half1);
            mergeSort(half2);

            int i = 0;
            int j = 0;
            int k = 0;

            while (j < length1 && k < length2) {
                if (half1[j].compareTo(half2[k]) <= 0) {
                    arr[i++] = half1[j++];
                } else {
                    arr[i++] = half2[k++];
                }
            }
            while (j < length1) {
                arr[i++] = half1[j++];
            }
            while (k < length2) {
                arr[i++] = half2[k++];
            }

        }
    }

    /**
     * The method sorts an array using quicksort sort
     * @param <T> - the type of elements in the array (must extend Comparable<T>)
     * @param arr - the array to be sorted
     */
    public static <T extends Comparable<T>> void quickSort(T [] arr) {
        quicksortPortion(arr, 0, arr.length - 1);
    }
    /**
     * The method sorts a portion of the array between two given
     * indices using quicksort algorithm. The method is recursive.
     * @param <T> - the type of elements in the array (must extend Comparable<T>)
     * @param arr - the array to be sorted
     * @param begin - index of the first element of the portion to sort
     * @param end - index of the last element of the portion to sort
     */
    public static <T extends Comparable<T>> void quicksortPortion(T arr[], int begin, int end) {
        if(begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quicksortPortion(arr, begin, partitionIndex - 1);
            quicksortPortion(arr, partitionIndex + 1, end);
        }
    }

    private static <T extends Comparable<T>> int partition(T arr[], int begin, int end) {
        T pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;

                T Temp = arr[i];
                arr[i] = arr[j];
                arr[j] = Temp;
            }
        }

        T Temp = arr[i+1];
        arr[i + 1] = arr[end];
        arr[end] = Temp;

        return i + 1;
    }
}

