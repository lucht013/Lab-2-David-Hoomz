//Hoomz Damte   
import java.util.Arrays;

public class SortingMethods {
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

