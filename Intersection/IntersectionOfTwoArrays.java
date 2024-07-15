package Intersection;



/*
Pseudocode =>
    1. Create HashSet
    2. Loop using for to iterate over array 1
    3. loop over array22 and check if its match with array1

 */

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

    public static int intersaction(int arr1[], int arr2[]){
//        create Hash Set to store unique values
        HashSet<Integer> set = new HashSet <>();
        int count = 0;   // if we want final count, then we need to initialize the count as 0
        ArrayList<Integer> commonElm = new ArrayList<>();


//        loop over the first array to get unique elements and store in set
        for(int i=0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
//        loop over the second array to get common value and store it and remove it after storing
        for(int j=0; j < arr2.length; j++){
            if(set.contains(arr2[j])){
                count++;
                System.out.println("Common Elements : " + arr2[j]);
                set.remove(arr2[j]);
            }
        }
        return count;

    }

    public static void main ( String[] args ) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4,1};
        System.out.println(intersaction(arr1, arr2));



    }
}
