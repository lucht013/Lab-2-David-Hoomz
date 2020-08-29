public class Tests {
    public static void main(String[] args){
        System.out.println("TestIntTest passed: " + testIntTest());
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
}
