package Sorting;

public class BubbleSort {
    public static void printArray(int arr[]){
        for(int array : arr){
            System.out.print(array + " ");
        }
        System.out.println();
    }

    public static void main ( String[] args ) {
        int arr[] = {8,2,4,6,10,3,7,9,1,5};

//        first, I need to iterate over an array
        for(int i = 0; i < arr.length - 1; i++){ // outer loop
            for( int j = 0; j < arr.length - i -1; j++){
//                check condition
                if( arr[j] > arr[j+1]){
//                    swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

//        Selection Sort
//        for(int i=0; i < arr.length - 1; i++){
//            int smallestElement = i;
//            for(int j = i+1;  j < args.length-1; j++){
//                if(arr[smallestElement] > arr[j]){
//                   smallestElement = j;
//                }
//                int temp = arr[smallestElement];
//                arr[smallestElement] = arr[i];
//                arr[i] = temp;
//            }
//        }
        printArray(arr);
    }
}
