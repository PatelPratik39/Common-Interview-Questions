package Sorting.sorting;

public class SelectionSort {

//    private static void selectionSort ( int[] arr ) {
//
//        int n = arr.length;
//
////        Traverse through the array elements
//        for(int i = 0; i < n - 1; i++){
////            find a minimum element from an array
//            int minElement = i;
//            for(int j = i+1; j < n; j++){
//                if(arr[j] < arr[minElement]){
//                    minElement = j;
//                }
//            }
////            swap the element to the first element
//            int temp = arr[minElement];
//            arr[minElement] = arr[i];
//            arr[i] = temp;
//        }
//    }


//    Selection Sort :
//    Step1 :   Find the smallest element from an array
//    step2  : Swap it with first element of an unsorted array
//    Step3 : repeted this steps to an unsorted array keep swapping
//   Time Complexity = O(n^2)
//    Space Complexity = O(1)


    private static void selectionSort ( int[] arr ) {

        for(int i = 0; i < arr.length; i++){
            int minEle = i;
            for(int j = i+ 1; j < arr.length; j++){
                if(arr[j] < arr[minEle]) {
                    minEle = j;
                }
            }
//            swapp the elements with first element
            int temp = arr[minEle];
            arr[minEle] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main ( String[] args ) {
        int arr[] = {64,25,12,2,22,64,22,11,9, 5, 6, 2, 33, 4 };
        System.out.print("Original array: ");
        printArray(arr);
        selectionSort(arr);
        System.out.print("Sorted array: ");
        printArray(arr);
    }



    private static void printArray ( int[] arr ) {
        for(int num :  arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }


}
