/*

K’th Largest element in BST using constant extra space
Given a binary search tree, task is to find Kth largest element in the binary search tree.

Input :  k = 3
         Root of following BST
            10
          /    \
         4      20
        /      /   \
       2     15     40
Output : 15

Time Compelxity  = O(h+ k)
and space complexity = O(h)

 */

package BST;

public class LongestKthElement  {
    static int count = 0;
    private static Node findKthLargest ( Node root, int k ) {

//        base case
        if (root == null) return null;  // base case
        Node right = findKthLargest(root.right, k);  // recursively search in right subtree
        if(right != null) return right;  // if kth the largest id found in the right subtree, return it
        count++;  // keep track of the node visited
        if(count == k) return root;

        return findKthLargest(root.left,k);
    }

    public static void main ( String[] args ) {
        LongestKthElement tree = new LongestKthElement();
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
//        root.left = new Node(8);
//        root.right = new Node(22);
//        root.left.left = new Node(4);
//        root.left.right = new Node(12);
//        root.left.right.left = new Node(10);
//        root.left.right.right = new Node(14);

        int k = 3;
        Node result = findKthLargest(root, k);

        if (result != null) {
            System.out.println(k + " -th largest element is " + result.data);
        } else {
            System.out.println("There are less than " + k + " nodes in the BST.");
        }
    }


}
