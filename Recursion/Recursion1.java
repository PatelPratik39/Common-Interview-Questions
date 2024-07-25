package Recursion;

public class Recursion1 {

//    this function will print Numbers from 1 to 5
    public static void printNum(int n){
//        base case
        if(n == 0){
            return;
        }
        System.out.println(n);
        printNum(n-1);
    }
    public static void printNum2(int m){
//        base case to print 1 to 5
        if(m == 6){
            return;
        }
        System.out.println(m);
        printNum2(m+1);
    }
    public static void main ( String[] args ) {
        int n = 5; //define a int value
        int m= 1;
        printNum(n);  //calling a method to print num
        System.out.println();
        printNum2(m);
    }
}
