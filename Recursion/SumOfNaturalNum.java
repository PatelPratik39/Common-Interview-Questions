/*
    Print sum of first n Natural Numbers using recursive function
 */

package Recursion;

public class SumOfNaturalNum {


    public static void printSumOfNum( int i, int n, int sum){

//        base case
        if(i == n){
            sum = sum + i;
            System.out.println(sum);
            return;
        }
        sum = sum + i;
        printSumOfNum(i+1,n, sum);
        System.out.println(sum);
    }

    public static void printSum(int i, int n, int sum){
//        base case
        if(i == n){
            sum += i;
            System.out.println(sum);
            return;
        }
        sum += i;
        printSum(i+1,n,sum);
        //empty
        System.out.println( i + " = i + sum = " + sum);
    }

    public static void main ( String[] args ) {
        printSum(1,5,0);
        System.out.println();
        printSumOfNum(1, 10,0);
    }
}
