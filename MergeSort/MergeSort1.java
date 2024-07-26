
/*
Merge Sort
1.  Take an Array, find Mid, starting index, ending index
2. Recursively divide each array into half so starting index, mid-index and ending index
3. Split each array into a single element then compare it with each element in sorted manner
4. Conquer them into an array with a sorted manner.
5. Compare 2 arrays with each other and store into a temp array then merged into the original array
6. Merge sort follows Divide and Conquer formation, so I need to define two methods that is divide and conquer
7. TIME COMPLEXITY = O( n log n) for best average and worst case
8. SPACE COMPLEXITY = O(n) because it creates new memory for merging arrays
 */


package MergeSort;

import java.util.Arrays;

public class MergeSort1 {

    public static void conquer(int originalArray[], int si, int mid, int ei){
//   to perform conquering, I need to allocate new memory, so I can store merged array elements,
//        for that i need to find a size of the array through endingIndex - starting Index plus 1 so I can get accurate size of an array

        int mergedArray[] = new int[ei - si + 1];
        int index1 = si;   // this index is tracking first half array index number
        int index2 = mid + 1; // this index is tracking second half array that starts from mid + 1
        int x = 0;   // this index 0 starts from a mergedArray array

        while(index1 <= mid && index2 <= ei){  // keep sorting the elements until mid and ending index
            if(originalArray[index1] <= originalArray[index2]){
                mergedArray[x++] = originalArray[index1++];
            } else {
                mergedArray[x++] = originalArray[index2++];
            }
        }
//        below while loops run if any of the array has more elements left to be inserted into new array
        // Copy remaining elements from the first subarray, if any
        while (index1 <= mid) {
            mergedArray[x++] = originalArray[index1++];
        }

        // Copy remaining elements from the second subarray, if any
        while (index2 <= ei) {
            mergedArray[x++] = originalArray[index2++];
        }
        // Copy the sorted elements back to the original array
        for (int i = 0, j = si; i < mergedArray.length; i++, j++) {
            originalArray[j] = mergedArray[i];
        }
    }

//    create a function for divide an array into two
    public static void divide(int originalArray[], int si, int ei){
//        in some case,
        if(si >= ei){
            return;
        }

//        first of all, I need to find mid-element from an original array
         int mid = si + (ei - si) / 2 ;  // I need to use equation to prevent space complexity by using: mid = (si+ei) /2
        // Recursively divide the array
        divide(originalArray, si, mid); // Sort the first half
        divide(originalArray, mid + 1, ei); // Sort the second half

        // Merge the sorted halves
        conquer(originalArray, si, mid, ei);
    }

    public static void main(String[] args) {
//        int originalArray[] = {6, 3, 9, 5, 2, 8};
        int originalArray[] = {9,3,4,6,2,8,1,7,5};
        int n = originalArray.length;
        System.out.println("Original Array : " + Arrays.toString(originalArray));

        divide(originalArray, 0, n - 1);

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(originalArray[i] + " ");
        }
        System.out.println();
    }
}
