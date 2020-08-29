import java.util.Random;
public class Tests {
    public static void main(String[] args){
        System.out.println("testIntTest passed: " + testIntTest());
        System.out.println("");
        System.out.println("isSortedTest passed: " + isSortedTest());
        System.out.println("");
        System.out.println("quickSortTest passed: " + quickSortTest());
        System.out.println("");
    }

    static boolean testIntTest(){
        TestInteger test = new TestInteger();
        TestInteger chungus = new TestInteger();
        test.value = 5;
        chungus.value = 5000000;
        System.out.println("The value of test is: " + test.value);
        System.out.println("Number of comparisons that have occured in test: " + test.getComparisons());
        int results = test.compareTo(chungus);
        if(results == -1){
            System.out.println("Chungus is bigger than test");
        }else if(results == 1){
            System.out.println("ya got the numbers flipped");
        }else if(results == -999){
            System.out.println("ya donked up");
        }
        System.out.println("Number of times test has been compared: " + test.getComparisons());
        System.out.println("Number of times chungus has been compared: " + chungus.getComparisons());
        return test.getComparisons() == 1 && chungus.getComparisons() == 1;
    }

    static boolean isSortedTest(){
        TestInteger unsorted[] = new TestInteger[10];
        Random rand = new Random();
        for(int i = 0; i < unsorted.length; i++){
            unsorted[i] = new TestInteger();
            unsorted[i].value = rand.nextInt(10);
        }
        System.out.print("Unsorted: [");
        for(int i = 0; i < unsorted.length; i++){
            if (i < unsorted.length-1){
                System.out.print(unsorted[i].value + ", ");
            }else{
                System.out.print(unsorted[i].value);
            }

        }
        System.out.print("]");
        System.out.println();
        if(Lab2.isSorted(unsorted)){
            System.out.println("Failed unsorted detection");
            return false;
        }

        TestInteger sorted[] = new TestInteger[10];
        for(int i = 0; i < sorted.length; i++){
            sorted[i] = new TestInteger();
            sorted[i].value = i;
        }
        System.out.print("sorted: [");
        for(int i = 0; i < sorted.length; i++){
            if (i < sorted.length-1){
                System.out.print(sorted[i].value + ", ");
            }else{
                System.out.print(sorted[i].value);
            }

        }
        System.out.print("]");
        System.out.println();
        if(!(Lab2.isSorted(sorted))){
            System.out.println("Failed sorted detection");
            return false;
        }
        return true;
    }

    static boolean quickSortTest(){
        //A WORKING ARRAY IS [0,7,2,7,6,4,7,0,3,1]
        TestInteger testArray[] = new TestInteger[10];
        Random rand = new Random();
        for(int i = 0; i < testArray.length; i++){
            testArray[i] = new TestInteger();
            testArray[i].value = rand.nextInt(10);
        }
        System.out.print("Unsorted: [");
        for(int i = 0; i < testArray.length; i++){
            if (i < testArray.length-1){
                System.out.print(testArray[i].value + ", ");
            }else{
                System.out.print(testArray[i].value);
            }

        }
        System.out.print("]");
        System.out.println();
        Lab2.quicksort(testArray,0,testArray.length-1);
        System.out.print("sorted: [");
        for(int i = 0; i < testArray.length; i++){
            if (i < testArray.length-1){
                System.out.print(testArray[i].value + " (compared " + testArray[i].getComparisons() + " times)" + ", ");
            }else{
                System.out.print(testArray[i].value);
            }

        }
        System.out.print("]");
        System.out.println();
        return Lab2.isSorted(testArray);
    }

}
