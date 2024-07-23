package Recursion;

//Program to implement Factorial using recursion
class GFG {
//    recursive method to calculate factorial
    int fact(int n){
        int result;

//        base case: if n is 1, return 1
        if(n == 1) return 1;
        result = fact(n-1) * n;   // recursive call : fact(n-1) * n
        return result;
    }
}
public class Factorial {
    public static void main ( String[] args ) {
        GFG factorial = new GFG();
        System.out.println("Factorial of 3 is : " + factorial.fact(3));
        System.out.println("Factorial of 5 is : " + factorial.fact(5));
        System.out.println("Factorial of 8 is : " + factorial.fact(8));


    }
}
