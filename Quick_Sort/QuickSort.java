package Quick_Sort;

public class QuickSort {

    private static int partition ( int[] arr, int low, int high ) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j = low;  j < high; j++){
            if(arr[j] < pivot){
                i++;
//                swapping logic inside an array
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int arr[], int low, int high){
//        base case
            if(low < high){
                int pivotIndex = partition(arr, low, high);

                quickSort(arr, low, pivotIndex-1);  //recursion
                quickSort(arr, pivotIndex + 1, high); //recursion call
            }
    }



    public static void main ( String[] args ) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        System.out.println(n);

        quickSort(arr, 0 , n-1);   // i took high = n-1 because, length of an array is always n-1 that starts from i = 0;

//        print array
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
