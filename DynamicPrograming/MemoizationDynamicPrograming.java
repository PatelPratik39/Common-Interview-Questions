package DynamicPrograming;

import java.util.HashMap;

public class MemoizationDynamicPrograming {
    private HashMap<Integer, Integer> memoization = new HashMap<>();

    public int fib(int n){
//        base case
        if(n <= 1) return n;

//        check if the value is already computed or not
        if(memoization.containsKey(n)){
            return memoization.get(n);
        }

//        Compute the value and store it in the cache
        int result = fib(n-1)+ fib(n-2);
        memoization.put(n, result);
        return result;
    }

    public static void main ( String[] args ) {


        MemoizationDynamicPrograming memo = new MemoizationDynamicPrograming();
        System.out.println(memo.fib(20));
    }
}
