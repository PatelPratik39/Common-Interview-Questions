
/*

    Time Complexity = O(n)
    Space Complexity = O(1)
 */

package DynamicPrograming;

public class ClimbingStairs {

    private static int climbStairs ( int n ) {

        if(n == 1 ) return 1;
        if(n==2) return 2;

//        int dp[] = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;

        int first = 1;
        int second =2;
        int current = 0;

        for(int i = 3; i <= n; i++){
            current = first + second;
            first = second;
            second = current;
        }

        return current;
//        for(int i = 3; i <= n; i++ ){
//            dp[i] = dp[ i-1] + dp[i-2];
//        }
//        return dp[n];
    }

    public static void main ( String[] args ) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " steps: " + climbStairs(n)); // Output: 2

    }
}
