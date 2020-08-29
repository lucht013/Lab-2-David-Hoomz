import java.util.Arrays;
public class Lab2 {
    public static void main(String[] args){
    }

    public static void quicksort(TestInteger A[], int p, int r){
        if(A[p].compareTo(A[r]) == -1){
            int q = partition(A, p, r);
            quicksort(A, p, q-1);
            quicksort(A,p + 1, r);
        }
    }

    private static int partition(TestInteger A[], int p, int r){
        TestInteger x = A[r];
        int i = p - 1;
        TestInteger swap = new TestInteger();
        for(int j = p; j < r; j++){
            if(A[j].compareTo(x) == -1){
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
}
