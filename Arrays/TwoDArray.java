package Arrays;

import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            // Take input from users
            System.out.println("Enter the number of rows:");
            int rows = scanner.nextInt();
            System.out.println("Enter the number of columns:");
            int cols = scanner.nextInt();

            int[][] numbers = new int[rows][cols];

            // Input loops
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    numbers[i][j] = scanner.nextInt();
                }
            }
             System.out.println("Enter the X  :");
            int x = scanner.nextInt();

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(numbers[i][j] == x){
                        System.out.println(x + " found at locations at  ( "+ i + " , " +  j  + " )");
                    }
                }
            }

//            // Output loops
//            System.out.println("The elements of the array are:");
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//                    System.out.print(numbers[i][j] + " ");
//                }
//                System.out.println();
//            }
    }
}
