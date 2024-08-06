/*

Time Complexity  = Best Case -> O(n log n)
                   Worst Case -> O(n^2) because of selection of smaller and largest element is always choosen as the pivot
                   Average Case -> O(n log n)
Space Complexity = O(n log n) due to recursive stace space used in the function calls
 */


package Sorting.sorting;

public class QuickSort {

    private static void quickSort ( int[] arr, int low, int high ) {
        if(low < high){  //if no more partitioning tobe done
//            now partition the array and get the pivot index
            int pivot = partition(arr,low,high);
//            Recursive sort elements before after partition
            quickSort(arr,low, pivot-1);
            quickSort(arr, pivot+ 1, high);
        }
    }

    private static int partition ( int[] arr, int low, int high ) {
        int pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high -1; j++){
            //if a current element is smaller than the pivot
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return (i+1);
    }

    private static void swap ( int[] arr, int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 80,30, 30, 90, 40, 50, 70};

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

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
