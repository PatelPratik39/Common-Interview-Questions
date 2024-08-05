package Arrays;

import java.util.Scanner;

public class TwoDimensionArray {

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Row ");
        int rows = sc.nextInt();
        System.out.println("Enter your Column ");
        int cols = sc.nextInt();

//        now create amn 2D array
        int [][] numbers =  new int[rows][cols];

        for(int i = 0 ; i< rows; i++){
            for(int j = 0; j < cols; j++){
                numbers[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the X  :");
        int x = sc.nextInt();

        for(int i = 0;  i< rows; i++){
            for(int j =0; j < cols; j++){
//                compare with x
                if(numbers[i][j] == x){
                    System.out.println(x + " found at locations at  ( "+ i + " , " +  j  + " )");
                }
            }
        }
    }
}
