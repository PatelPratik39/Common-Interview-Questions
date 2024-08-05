package BST;

public class ShortestDistance2 {
// Helper method 1 to find longest Common Ancestor
    private static Node findLCA(Node root, int n1, int n2){
        if(root == null) return null;

        if(root.data > n1 && root.data > n2) return findLCA(root.left,n1,n2);
        if(root.data < n1 && root.data < n2) return findLCA(root.right, n1, n2);

        return root;  //this is LCA
    }


// Helper method2: now find the distance to given nodes

    private static int findDistanceFromRoot ( Node root, int data ) {
        if(root == null) return -1;  // return -1 means if node is null then it returns -1

        int distance = 0;
        while(root != null){
            if(data < root.data){
                root = root.left;
                distance++;
            } else if( data > root.data){
                root = root.right;
                distance++;
            } else {
                 return distance;
            }
        }
        return -1; // if no node found;
    }

    public static int findDistanceBetweenNodes(Node root, int n1, int n2){

        Node lca = findLCA(root,n1,n2);
        int distance1 = findDistanceFromRoot(lca, n1);
        int distance2 = findDistanceFromRoot(lca, n2);

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
        int n1 = 3, n2 = 25;
        int distance = findDistanceBetweenNodes(root,n1, n2);
        System.out.println("Shortest distance between " + n1 + " and " + n2 + " is " + distance);
    }
}
