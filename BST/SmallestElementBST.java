

/*

    Find k-th smallest element in BST (Order Statistics in BST)

 */

package BST;

public class SmallestElementBST {
    int count = 0;
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    private Node kthSmallest ( Node root, int k ) {

//        base case
        if(root == null){
            return null;
        }
//        search kth the smallest element in tree that is always in left side of the tree
        Node left =  kthSmallest(root.left, k);

        if (left != null) {
            return left;
        }
        count++;  //count wll increase till node visited so far
        if(count == k){  //if count become k, then this is the kth smallest element in the node
            return root;
        }
        return kthSmallest(root.right,k);
    }

    public static void main ( String[] args ) {
        SmallestElementBST tree = new SmallestElementBST();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int k = 5;
        Node result = tree.kthSmallest(root, k);

        if(result != null){
            System.out.println(k + "-th smallest element is " + result.data);
        } else {
            System.out.println("There are less than " + k + " nodes in the BST.");
        }

    }


}
