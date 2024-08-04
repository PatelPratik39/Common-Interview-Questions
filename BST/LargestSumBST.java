/*

The Largest number in BST which is less than or equal to N
// creating following BST
    /*
                  5
               /   \
             2     12
           /  \    /  \
          1   3   9   21
                     /   \
                    19   25
Time Complexity:  O(h), where h is the height of the tree. This is efficient for balanced trees, where the height is logarithmic relative to the number of nodes.
Space Complexity: O(1) for the iterative approach, using constant space.
 */

package BST;

public class LargestSumBST {

    private static int findLargestLessThanOrEqualToN ( Node root, int N ) {
        int largest = Integer.MIN_VALUE; // Initialize with the smallest Value
        Node currentNode = root;
        while(currentNode != null){
            if(currentNode.data == N){
                return currentNode.data;   //if current Node's value is equal to N, return it
            } else if (currentNode.data < N) {
                largest = currentNode.data;  // Update largest since current node is less than or equal to N
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return largest;
    }

    public static void main ( String[] args ) {
        // Creating the specified BST
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);

        int N = 23;
        int result = findLargestLessThanOrEqualToN(root, N);
        System.out.println("Largest number in BST less than or equal to " + N + " is " + result);
    }


}

