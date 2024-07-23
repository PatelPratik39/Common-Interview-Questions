package Recursion;

public class Fibonacci {

    static int fib(int N){
        if(N==0 || N==1)
            return N;
        return fib(N-1 )+ fib(N-2);
    }
    public static void main ( String[] args ) {
        // Fibonacci of 3
        System.out.println("Fibonacci of " + 3 + " "
                + fib(3));

        // Fibonacci of 4
        System.out.println("Fibonacci of " + 4 + " "
                + fib(4));

        // Fibonacci of 5
        System.out.println("Fibonacci of " + 5 + " "
                + fib(5));
    }
}
