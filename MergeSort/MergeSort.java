package MergeSort;

public class MergeSort {

    public static void conquer(int arr[], int si, int mid, int ei) {
        // New array to store sorted elements
        int merged[] = new int[ei - si + 1];
        int idx1 = si;   // Starting index of the first half
        int idx2 = mid + 1;   // Starting index of the second half
        int x = 0;     // Index for the merged array

        // Merge two halves
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        // Copy remaining elements from the first half
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        // Copy remaining elements from the second half
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // Copy sorted elements back into the original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) {  // base case if the array segment has one or no elements
            return;
        }

        int mid = si + (ei - si) / 2;  // Get the middle index
        divide(arr, si, mid);          // Recursively divide the first half
        divide(arr, mid + 1, ei);      // Recursively divide the second half

        // Merge the divided halves
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        divide(arr, 0, n - 1);

        // Print sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
