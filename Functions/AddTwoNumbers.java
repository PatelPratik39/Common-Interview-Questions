package Functions;

import java.util.Scanner;

public class AddTwoNumbers {

    public static int calculateSum(int a, int b){
        int sum = a + b;
        return sum;
    }

    public static int calculateProduct(int c, int d){
        return c * d;
    }

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int sum = calculateSum(a,b);
        System.out.println("Sum Of Two Int Numbers  is : " + sum);
        System.out.println("------");
        System.out.println("Product of 2 Numbers : " + calculateProduct(c, d));
    }
}
