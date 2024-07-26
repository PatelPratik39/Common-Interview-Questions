package MergeSort;

import java.util.Arrays;

public class MergeSort2 {
//    i need to follow divide and conquer approach

//    create conquer method
    private static void conquer ( int[] originalArray, int si, int mid, int ei ) {
//        allocate new memory for a storing merged array
        int merged[] = new int[ei - si + 1];

        int index1 = si;   // First half-array starting index
        int index2 = mid + 1;  // Second half-array starting index
        int x = 0; // New starting index

        while(index1 <= mid && index2 <= ei){
            if(originalArray[index1] <= originalArray[index2]){
                merged[x++] = originalArray[index1++];
            } else {
                merged[x++] = originalArray[index2++];
            }
        }

        //let's insert all remaining elements from array1
        while (index1 <= mid){
            merged[x++] = originalArray[index1++];
        }
        while (index2 <= ei){
            merged[x++] = originalArray[index2++];
        }

//        copy the sorted array to an original array
        for(int i =0, j = si; i < merged.length; i++,j++){
            originalArray[j] = merged[i];
        }
    }


//    create divide function

    public static void divide(int originalArray[], int si, int ei) {
//        base case
        if (si >= ei) {
            return;
        }
//        let's divide an array into two arrays
//        I need to find mid
        int mid = si + (ei - si) / 2;  // (si + ei) / 2

//        Recursive call to originalArray
        divide(originalArray, si, mid);
        divide(originalArray, mid + 1, ei);

//        now I need to conquer the sorted array into origianl array
        conquer(originalArray, si, mid, ei);

    }

    public static void main ( String[] args ) {
        int originalArray[] = {9,3,4,6,2,8,1,7,5};
        int n = originalArray.length;

        System.out.println("Original Array : " + Arrays.toString(originalArray));

        divide(originalArray, 0, n-1);

        for(int i : originalArray){
            System.out.print(i + " - ");
        }
        System.out.println();
    }
}


