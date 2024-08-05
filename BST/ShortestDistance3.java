//Time Complexity = O(h)
//Space CComplexity = O(1)

package BST;

public class ShortestDistance3 {

    //    Step 1 find Longest Common Ancestor from root to given nodes
    private static Node findLCA(Node root, int n1, int n2){
            if(root == null) return null;

            if(root.data > n1 && root.data > n2) return findLCA(root.left,n1,n2);
            if(root.data < n1 && root.data < n2) return findLCA(root.right,n1, n2);

            return root; // This is LCA node
    }

//    step 2 helper function calculates distance between two Nodes
    private static int findDistanceFromRoot(Node root, int data){
        if(root == null) return -1; //if No root found then return -1;
        int distance = 0;  // initialize distance as 0
        Node current = root;
//        run a loop till find distance
        while(current != null){
            if(data < current.data){
                current = current.left;
                distance++;
            } else if( data > current.data){
                current = current.right;
                distance++;
            } else {
                return distance;
            }
        }
        return -1;  // if nor node found
    }

    //    Step 3 Find the distance from root to node
    public static int findDistanceBetweenNodes(Node root, int n1, int n2 ){
        Node lca = findLCA(root, n1, n2);

        int distance1 = findDistanceFromRoot(lca, n1);
        int distance2 = findDistanceFromRoot(lca,n2);

        if (distance1 == -1 || distance2 == -1) {
            // If either of the nodes is not found, return -1
            System.out.println("One or both nodes not found in the tree.");
            return -1;
        }

        return distance1 + distance2;
    }


    public static void main ( String[] args ) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);
        int n1 = 2, n2 = 12;
        int distance = findDistanceBetweenNodes(root,n1, n2);
        System.out.println("Shortest distance between " + n1 + " and " + n2 + " is " + distance);
    }
}
