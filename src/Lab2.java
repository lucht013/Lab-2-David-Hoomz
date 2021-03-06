import java.util.Arrays;
import java.util.Random;


public class Lab2 {
    public static void main(String[] args){
       System.out.println("Comparing 10,000 random testInts from 1 to 1,000,000 5 times...");
       normalTimSortComparison();
       System.out.println(" ");
       System.out.println("Comparing 10,000 ordered testInts from 1 to 1,000,000 5 times...");
       increasingOrdinalTimSortComparison();
       System.out.println(" ");
       System.out.println("Comparing 10 sorted sequences of 1,000 ordered elements from 1 to 1,000,000 5 times...");
       tenSortedTimSortComparison();
       System.out.println(" ");
       System.out.println("Comparing 100 sorted sequences of 100 ordered elements from 1 to 1,000,000 5 times...");
       hundredSortedTimSortComparison();
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
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            TestInteger timTestArray[] = new TestInteger[length];
            for (int i = 0; i < testArray.length; i++) {
                int value = rand.nextInt(bound);
                testArray[i] = new TestInteger();
                testArray[i].value = value;
                //testArray[0].resetCounter();

                timTestArray[i] = new TestInteger();
                timTestArray[i].value = value;
                //timTestArray[0].resetCounter();

            }

            //testArray[0].resetCounter();
            //timTestArray[0].resetCounter();

            System.out.println("Quicksort is sorted: " + isSorted(testArray) + " with " + testArray[0].getComparisons() + " comparisons");
            long start = System.currentTimeMillis();
            quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            System.out.println("Quicksort validation: " + isSorted(testArray));

            System.out.println("Timsort is sorted: " + isSorted(timTestArray) + " with " + timTestArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + " TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println("Timsort validation: " + isSorted(timTestArray));
            System.out.println();
        }
    }

    public static void increasingOrdinalTimSortComparison(){
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            TestInteger timTestArray[] = new TestInteger[length];
            int seed = rand.nextInt(bound-10001);

            testArray[0] = new TestInteger();
            //testArray[0].resetCounter();
            testArray[0].value = seed;

            timTestArray[0] = new TestInteger();
            //timTestArray[0].resetCounter();
            timTestArray[0].value = seed;

            for (int i = 1; i < length; i++) {
                testArray[i] = new TestInteger();
                testArray[i].value = testArray[i-1].value + 1;
                timTestArray[i] = new TestInteger();
                timTestArray[i].value = timTestArray[i-1].value + 1;
            }


            System.out.println("Quicksort is sorted: " + isSorted(testArray) + " with " + testArray[0].getComparisons() + " comparisons");
            long start = System.currentTimeMillis();
            quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            System.out.println("Quicksort validation: " + isSorted(testArray));

            System.out.println("Timsort is sorted: " + isSorted(testArray) + " with " + timTestArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Timsort is sorted: " + isSorted(timTestArray));
            System.out.println("Trial " + j + " TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println();
        }
    }

    public static void tenSortedTimSortComparison(){
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            TestInteger timTestArray[] = new TestInteger[length];
            int seed = rand.nextInt(bound-1001);
            for (int i = 0; i <= 9; i++) {
                seed = rand.nextInt(bound-1001);
                testArray[i * 1000] = new TestInteger();
                testArray[i * 1000].value = seed;
                //testArray[0].resetCounter();

                timTestArray[i * 1000] = new TestInteger();
                timTestArray[i * 1000].value = seed;
                //timTestArray[0].resetCounter();

                for(int k = 1; k < 1000; k++){
                    testArray[i * 1000 + k] = new TestInteger();
                    testArray[i * 1000 + k].value = testArray[i * 1000 + k - 1].value + 1;

                    timTestArray[i * 1000 + k] = new TestInteger();
                    timTestArray[i * 1000 + k].value = timTestArray[i * 1000 + k - 1].value + 1;
                }
            }

            System.out.println("Quicksort is sorted: " + isSorted(testArray));
            System.out.println("Timsort is sorted: " + isSorted(timTestArray));

            long start = System.currentTimeMillis();
            quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            System.out.println("Quicksort validation: " + isSorted(testArray));
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + " TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println("Timsort validation: " + isSorted(timTestArray));
            System.out.println();
        }
    }

    public static void hundredSortedTimSortComparison(){
        int length = 10000;
        int bound = 1000000;
        int repititions = 5;
        Random rand = new Random();
        for(int j = 1; j<=repititions; j++){
            TestInteger testArray[] = new TestInteger[length];
            TestInteger timTestArray[] = new TestInteger[length];
            int seed = rand.nextInt(bound-1001);
            for (int i = 0; i <= 99; i++) {
                seed = rand.nextInt(bound-101);

                testArray[i * 100] = new TestInteger();
                testArray[i * 100].value = seed;
                //testArray[0].resetCounter();

                timTestArray[i * 100] = new TestInteger();
                timTestArray[i * 100].value = seed;
                //timTestArray[0].resetCounter();

                for(int k = 1; k < 100; k++){
                    testArray[i * 100 + k] = new TestInteger();
                    testArray[i * 100 + k].value = testArray[i * 100 + k - 1].value + 1;

                    timTestArray[i * 100 + k] = new TestInteger();
                    timTestArray[i * 100 + k].value = timTestArray[i * 100 + k - 1].value + 1;
                }
            }

            System.out.println("Quicksort is sorted: " + isSorted(testArray) + " with " + testArray[0].getComparisons() + " comparisons");
            long start = System.currentTimeMillis();
            quicksort(testArray, 0, testArray.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Trial " + j + " quicksort result: " + (end-start) + "ms with " + testArray[0].getComparisons() + " comparisons");
            System.out.println("Quicksort validation: " + isSorted(testArray));

            System.out.println("Quicksort is sorted: " + isSorted(testArray) + " with " + timTestArray[0].getComparisons() + " comparisons");
            start = System.currentTimeMillis();
            Arrays.sort(timTestArray);
            end = System.currentTimeMillis();
            System.out.println("Trial " + j + " TimSort result: " + (end-start) + " ms with " + timTestArray[0].getComparisons() + " comparisons");
            System.out.println("Timsort validation: " + isSorted(timTestArray));
            System.out.println();
        }
    }
}
