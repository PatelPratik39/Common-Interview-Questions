
// check if an array is a sorted array (Strictly increasing)

package Recursion;

public class IsSortedArray {

//    Time complexity is O(n) based on array length

    public static boolean isSorted(int arr[], int index) {
//    base case checks tha if we are at last index oif an array, then i need to simply return true because array is sorted already
        if(index == arr.length - 1){ //
            return true;
        }
//        if(arr[index] < arr[index + 1]) {
//            //array is sorted
//            return isSorted(arr, index + 1);
//        }else{
//            return false;
//        }

        //second way
        if(arr[index] >= arr[index+1]){
            return false;  //unsorted array
        }
        return isSorted(arr,index+1);
    }
    public static void main ( String[] args ) {
        int arr[] = {1,2,3,3,5};
        System.out.println( isSorted(arr,0));
    }
}
