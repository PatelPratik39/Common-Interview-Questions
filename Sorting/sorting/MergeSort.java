/*

     Merge Sort
     Time Complexity =>
     Space Complexity =>
 */

package Sorting.sorting;

public class MergeSort {

    private static void mergeSort ( int[] arr, int left, int right ) {
        if(left < right) {
            int mid = left + (right - left) / 2;  //find the middle point
//            recursively sort the first half
            mergeSort(arr, left, mid);
//            recursively sort second half
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);  //now merge both the array in sorted order
        }
    }

    private static void merge ( int[] arr, int left, int mid, int right ) {
        //first find the size of both the arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
//        now create temp arrays for left and right SubArrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

//        copy the data to temp arrays
        for(int i=0; i<n1; i++){
            leftArr[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++){
            rightArr[j] = arr[mid + 1 + j];
        }

//        initialize indexes of first and second subArrays
        int i = 0, j=0;
        int k = left;

        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

//        now copy all the remaining arrays into left array
        while(j < n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


    public static void main ( String[] args ) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        printArray(arr);
    }
    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
