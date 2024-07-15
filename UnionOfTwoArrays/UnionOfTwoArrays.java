package UnionOfTwoArrays;

import java.util.*;
//for below problem, i need to use HashSet because HashSet avoid the reputations in adding and storing the rules.

public class UnionOfTwoArrays {

//    create a function for Unite these two arrays
    public static int union(int arr1[], int arr2[]){    // time Complexity of this function  => O(n)

//        1.  Create a HashSet
        HashSet<Integer> set = new HashSet<>();
//        2. Iterate over each Array and store elements into a union array
        for(int i=0; i < arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j = 0; j < arr2.length; j++){
            set.add(arr2[j]);
        }
        return set.size();

    }

    public static void main ( String[] args ) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4,1};
        System.out.println(union(arr1, arr2));
    }
}
