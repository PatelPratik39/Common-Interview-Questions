

/*

Minimize steps to reach K from 0 by adding 1 or doubling at each step
Given a positive integer K, the task is to find the minimum number of operations of the following two types, required to change 0 to K.

Add one to the operand
Multiply the operand by 2.

nput: K = 1
Output: 1
Explanation:
Step 1: 0 + 1 = 1 = K

Input: K = 4
Output: 3
Explanation:
Step 1: 0 + 1 = 1,
Step 2: 1 * 2 = 2,
Step 3: 2 * 2 = 4 = K

 */

package DynamicPrograming;

public class ReachKToOMinimize {
    public static int minStepToReachK(int K){
        int steps = 0;

        // Start from K and work backwards to 0
        while (K > 0) {
            // If K is even, divide by 2
            if (K % 2 == 0) {
                K = K/ 2;
            } else {
                // If K is odd, subtract 1
                K = K-1;
            }
            // Increment the step count
            steps++;
        }

        return steps;
    }

    public static void main ( String[] args ) {
        int K1 = 1;
        int K2 = 4;

        System.out.println("Minimum steps to reach " + K1 + " from 0: " + minStepToReachK(K1)); // Output: 1
        System.out.println("Minimum steps to reach " + K1 + " from 0: " + minStepToReachK(K2));
    }
}
