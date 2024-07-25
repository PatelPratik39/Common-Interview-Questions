package Sorting;

public class Sorting {

    public static void printArray(int arr[]){
        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main ( String[] args ) {
        int arr[] = {7,8,3,1,2};

        //bubble Sort -> time complexity = O(n^2)
        for(int i=0; i< arr.length - 1; i++){     // outer loop run n-1 time
            for(int j=0; j < arr.length - i -1; j++){  // inner loop run n*n
                if(arr[j] > arr[j + 1]){
//                    swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr);
    }
}
