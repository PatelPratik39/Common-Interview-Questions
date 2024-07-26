/*

 Print factorial of Num n using recursion
 */

package Recursion;

public class FactorialOfNumN {
    public static int calculateFactorialOfN(int n){
//        base case
        if(n == 1 || n == 0){
            return 1;
        }
//          i want to get the value of n-1 so i can count factorial  = n*(n-1)
        int fact_n1 = calculateFactorialOfN(n-1);
        int fact_n = n * fact_n1;
        return fact_n;
    }

    public static void main ( String[] args ) {
            int n = 5;
            int ans = calculateFactorialOfN(n);
        System.out.println(ans);
    }
}
