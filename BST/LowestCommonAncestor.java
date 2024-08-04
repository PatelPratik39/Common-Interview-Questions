
/*
        Find Lowest Common Ancestors.

        Input: LCA of 10 and 14
        Output:  12
        Explanation: 12 is the closest node to both 10 and 14
        which is a ancestor of both the nodes.

        Input: LCA of 8 and 14
        Output:  8
        Explanation: 8 is the closest node to both 8 and 14
        which is a ancestor of both the nodes.

        Time Complexity - O(H)

        // Constructing the following BST:
        //        20
        //       /  \
        //      8   22
        //     / \
        //    4  12
        //       / \
        //      10 14
 */

package BST;

public class LowestCommonAncestor {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Node findLCA ( Node root, int n1, int n2 ) {
        while(root != null){
            if(root.data > n1 && root.data > n2){
                root = root.left;
            }else if(root.data < n1 && root.data < n2){
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }


    public static void main ( String[] args ) {

        LowestCommonAncestor tree = new LowestCommonAncestor();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
//        int n1 = 10, n2 = 22;
        Node t = tree.findLCA(root, n1, n2);
        if (t != null)
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        else
            System.out.println("LCA not found.");

    }



}
