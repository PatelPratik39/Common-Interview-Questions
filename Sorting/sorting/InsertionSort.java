//Time Complexity : O(n^2)
// if Array is sorted then Time Complexity will be O(n)
//Space Complexity isO(1), because its in-place sorting ALGORITHM and required O(1) space
package Sorting.sorting;

public class InsertionSort {

    private static void insertionSort ( int[] arr ) {
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }
    public static void main ( String[] args ) {
        int arr[] = {64,25,12,2,22,64,22,11,9, 5, 6, 2, 33, 4 };
        System.out.print("Original array: ");
        printArray(arr);
        insertionSort(arr);
        System.out.print("Sorted array: ");
        printArray(arr);
    }
    private static void printArray ( int[] arr ) {
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();

    }
}
