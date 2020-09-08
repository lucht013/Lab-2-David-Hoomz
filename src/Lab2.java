import java.util.Arrays;
import java.util.Random;


public class Lab2 {
    public static void main(String[] args){
        System.out.println("Comparing 10,000 random testInts from 1 to 1,000,000 5 times...");
        normalTimSortComparison();


    }

    public static void quicksort(TestInteger A[], int p, int r){
        if(p < r){
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A,q + 1, r);
        }
    }

    private static int partition(TestInteger A[], int p, int r){
        TestInteger x = A[r];
        int i = p - 1;
        TestInteger swap = new TestInteger();
        for(int j = p; j < r; j++){
            int comparison = A[j].compareTo(x);
            if(comparison == -1 || comparison == 0){
               i++;
               swap = A[i];
               A[i] = A[j];
               A[j] = swap;
            }
        }
        swap = A[i + 1];
        A[i + 1] = A[r];
        A[r] = swap;
        return i + 1;
    }

    public static boolean isSorted(TestInteger A[]){
        for(int i = 0; i <= A.length-2; i++){
            if(!(A[i].value <= A[i + 1].value)){
                return false;
            }
        }
        return true;
    }

    public static void normalTimSortComparison(){
        int length = 50;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            for (int i = 0; i < testArray.length; i++) {
                testArray[i] = new TestInteger();
                testArray[i].value = rand.nextInt(bound);
            }
            TestInteger timTestArray[] = testArray;
            long start = System.currentTimeMillis();
            quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + "TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println();
        }
    }
}
