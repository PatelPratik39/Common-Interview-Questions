
// Given an Integer array of size n, find all elements that appear more than [n/3] times.
//    - nums[] = {1,3,2,5,1,3,1,5,1};   \\ 1
//        - nums[] = {1,2};    \\1,2

/*

Pseudocode:
        - Create HashMap
        - iterate over an array
        - check the length of the array
        - if element i is matching with the same element in an array, i will increase the number with +1 for that index value.
        - if not then i will add the value for the i as 1.
        - once this key value set up done inside hashMap, i need to use advance loop to iterate over the map using keySet() to get all keys.
        - then i will check whether the value of the key is > n/3 or not.
        - if its greater than n/3 than print that key

 */

import java.util.*;


public class FindMajorityNums {

//    create a function to find majority elements from an array using HAsh

    public static void majorityElements(int nums[]){
//        create a HashMap object using <K, V>

        HashMap<Integer, Integer> map = new HashMap<>();
//        set the array length to n variable
        int n = nums.length;

//        iterate over an array

        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])) {     // if this condition is true
                map.put(nums[i], map.get(nums[i]) + 1);   // set the key value pair in hashtable with adding 1 frequency
            } else {  // false
                map.put(nums[i], 1);
            }
        }
//        third step to get highest frequnecy value
        for (int key : map.keySet()){
            if(map.get(key) > n/3){
                System.out.println(key);
            }
        }
    }

    public static void main ( String[] args ) {

//        int nums[] = {1,3,2,5,1,3,1,5,1};   // output should be 1
        int nums[] = {1,2}; // output should be 1,2
        majorityElements(nums);
    }
}
