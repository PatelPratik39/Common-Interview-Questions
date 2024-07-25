/*

        Find a factorial of a number
        Example : Factorial for n! = n * (n-1) * (n-2) * (n-3) * .... * 1
        Ex : 5! = 5 x 4 x 3 x 2 x 1 => 120
 */

package Functions;

import java.util.Scanner;

public class Factorial {

//    create a new function to calculate factorials
    public static void printFactorial(int n){
//        LOOP

        if(n < 0){
            System.out.println("What are you doing Man!!! , its Invalid number");
            return;
        }
        int factorial = 1;   //initialize factorial as 1

        for(int i = n; i >= 1; i--){
            factorial = factorial * i;
        }
        System.out.println(factorial);
        return;
    }

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printFactorial(n);  //calling a function into the main method
    }
}
