package Sorting;

public class BubbleSort1 {

    public static void printArray(int arr[]){
        for( int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main ( String[] args ) {
        int arr[] = {8,2,4,6,10,3,7,9,1,5};

//     bubble Sort -> Time CComplexity will be O(n^2)
//        for(int i = 0; i <  arr.length - 1; i++){ //outer loop run for n times
//            for(int j = 0; j < arr.length-i-1; j++){  //inner loop run n-1 times
//                if(arr[j] > arr[j+1]){
////                    swap the element
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }

//        SELECTION SORT ALGORITHM -> Time Complexity = O(n^2)

        for(int i=0; i< arr.length - 1; i++){
            int smallest = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
    }
}
