package BST;

public class SmallestElementBST2 {
    int count = 0;

    private Node findKThSmallest ( Node root, int k ) {
//        base case
        if(root == null) return null;
        Node left = findKThSmallest(root.left,k);  //search in left side
        if(left != null) return left; //if kth the smallest element found in the left subtree, return it
        count++;  // increment count of visited node

        if(count == k) return root;

        return findKThSmallest(root.right,k);  // otherwise search in right subtree
    }

    public static void main ( String[] args ) {
        SmallestElementBST2 tree = new SmallestElementBST2();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int k = 2 ;

        Node result = tree.findKThSmallest(root, k);
        if (result != null) {
            System.out.println(k + "-th smallest element is " + result.data);
        } else {
            System.out.println("There are less than " + k + " nodes in the BST.");
        }
    }


}
