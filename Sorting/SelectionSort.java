package Sorting;

public class SelectionSort {

//    write public method of printArr
    public static void printArray(int arr[]){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main ( String[] args ) {
        int arr[] = {8,2,4,6,10,3,7,9,1,5};

        for(int i = 0; i < arr.length - 1; i++){
            int smallestElm = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[smallestElm] > arr[j]){
                    smallestElm = j;
                }
            }
                int temp = arr[smallestElm];
                arr[smallestElm] = arr[i];
                arr[i] =temp;
            }
        printArray(arr);
    }
}
