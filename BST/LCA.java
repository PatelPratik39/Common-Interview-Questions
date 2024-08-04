package BST;

public class LCA {
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node findLCA ( Node root, int n1, int n2 ) {
        if (root == null) return null;  //base case
        if (root.data < n1 && root.data < n2) return findLCA(root.right,n1,n2);
        if (root.data > n1 && root.data > n2) return findLCA(root.left, n1, n2);
        return root;
    }

    public static void main ( String[] args ) {
        LCA tree  = new LCA();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int n1=10,n2= 14;
        Node t = tree.findLCA(root,n1,n2);
        if(t != null){
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        } else {
            System.out.println("LCA not found.");
        }
    }


}
