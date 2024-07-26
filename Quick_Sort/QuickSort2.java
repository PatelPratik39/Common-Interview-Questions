package Quick_Sort;

public class QuickSort2 {

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low -1;

        for (int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
//                swapp
                int temp  = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;  // pivot index
    }

    private static void quickSort ( int[] arr, int low, int high ) {
//        base class
        if(low < high){
            int pivotIndex = partition(arr, low, high);

//            recursive call for repeat the pivot finder
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static void main ( String[] args ) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        System.out.println(n);

        quickSort(arr, 0, n -1);

//        print array
        for(int i : arr){
            System.out.print(i + " - ");
        }
        System.out.println();

    }


}
