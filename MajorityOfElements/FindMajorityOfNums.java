package MajorityOfElements;

import java.util.*;

public class FindMajorityOfNums {

//    create a function to find the frequency

    public static void majorityElements(int nums[]){
//        first step to create a Hash Map
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;  //find the length of an array

//        iterate over the array
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);

            } else {
                map.put(nums[i], 1);
            }
        }

        for( int key : map.keySet()){
            if(map.get(key) > n/3){
                System.out.println(key);
            }
        }
    }

    public static void main ( String[] args ) {
        int nums[] = {1, 2, 3, 4, 5, 1, 2, 3, 1, 1};
        majorityElements(nums);
    }
}
