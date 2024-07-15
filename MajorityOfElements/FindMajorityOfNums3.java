package MajorityOfElements;

import java.util.HashMap;

public class FindMajorityOfNums3 {
    public static void main ( String[] args ) {
//        int nums[] = {1,3,2,5,1,3,1,5,1};
        int nums[] = {1,3,3,3,3,3,3,5,1,3,1,5,1,1};
        findMajorityElements(nums);
    }

    private static void findMajorityElements ( int[] nums ) {
//        1.    Create HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
//        2.    Iterate over an array to check a key-num inside hashmap present ot not,
//              if present then check frequency if same key comes in loop then add one frequency
//              if not exist and create a new one if not exists.
        for(int i = 0; i< n; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
//        3.    Once hashmap is set with updated frequency, then iterate over the map usig key set
//              and check if the frequency is > n/3 or not, if more that n/3 then print otherwise not.

        for(int key : map.keySet()){
            if(map.get(key) > n/3){
                System.out.println(key);
            }
        }

    }
}
