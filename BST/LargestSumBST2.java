package BST;

public class LargestSumBST2 {

    private static int findLongestNumberInBSTtoN ( Node root, int N ) {
        int largest =  Integer.MIN_VALUE;  // initialize smallest integer value
        Node current = root;
        while(current != null){
//            base case; =  if current node's data is equal to N then return currentNode.data
            if(current.data == N){
                return current.data;
            } else if (current.data < N) {  // elseif current node data is less than N
                largest = current.data;   // then store largest as current.data because it's still smaller
                current = current.right;  // and now move to the right subtree
            } else  {
                current = current.left;  // Move to the left subtree to find a value less than or equal to N
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
        int N = 24;
        int result = findLongestNumberInBSTtoN(root, N);
        System.out.println( "longest : " + result);

    }


}
