/*

Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST).
If the complete Binary Tree is BST, then return the size of the whole tree.

Time Complexity: O(n)
Space Complexity : O(h)
 */


package BST;

public class LargestBSTSubTree {

    static class SubTree{
        int size;      // Size of the subtree
        int min;       // Minimum value in the subtree
        int max;       // Maximum value in the subtree
        boolean isBST; // Whether the subtree is a BST

        SubTree(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    private static SubTree findLargestBST(Node node){
        if(node == null){
            return new SubTree(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        // Recursively find the largest BST in the left and right subtrees
        SubTree leftSubTree = findLargestBST(node.left);
        SubTree rightSubTree = findLargestBST(node.right);

        // Initialize current node's subtree info
        SubTree currentInfo = new SubTree(0, 0, 0, false);

        if(leftSubTree.isBST && rightSubTree.isBST && leftSubTree.max < node.data && node.data < rightSubTree.min){
//            current Subtree is BST or not
            currentInfo.isBST = true;
            currentInfo.size = 1 + leftSubTree.size + rightSubTree.size;
            currentInfo.min = Math.min(node.data, leftSubTree.min);
            currentInfo.max = Math.max(node.data,rightSubTree.max);

        } else {
            currentInfo.isBST = false;
            currentInfo.size = Math.max(leftSubTree.size, rightSubTree.size);
        }
        return currentInfo;
    }

    // Public function to return the size of the largest BST in the tree
    private static int largestBST ( Node root ) {
        SubTree info = findLargestBST(root);
        return info.size;
    }
    public static void main ( String[] args ) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);

        int size = largestBST(root);
        System.out.println("Size if the largest BST is : " + size);

    }


}
