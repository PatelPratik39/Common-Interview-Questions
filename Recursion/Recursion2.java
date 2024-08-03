/*

 */

package Recursion;


//Time Complexity  => O(2^n)
public class Recursion2 {
    public static void towerOfHanoi(int n, String source, String helper, String destination){
//        Base case - > when we have only 1 disk to transfer, we can do it directly
        if(n == 1){
            System.out.println("Transfer Disk " + n + " from "+ source + " to " + destination);
            return;
        }

//        below recursive function has swapped parameters because, i need to transfer a source to helper function first and then destination tower
        towerOfHanoi(n-1,source,destination,helper);  // recursive function to transfer the data from source tower to helper function with n-1
        System.out.println("Transfer Disk " + n + " from "+ source + " to " + destination);
        System.out.println();
        towerOfHanoi(n-1, helper, source,destination);   // now transferring data helper to destination


    }
    public static void main ( String[] args ) {

        int n = 3;
        towerOfHanoi(n,"Source_Tower", "Helper_Tower", "Destination_Tower");

    }
}
