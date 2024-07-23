package Recursion;

public class RecursivelyFindRange {
    public static void main ( String[] args ) {
        int result = sum(20);
        System.out.println(result);
    }
    public static int sum(int k){
        if(k > 0){
            return k + sum(k -1);
        } else{
            return 0;
        }
    }
}
