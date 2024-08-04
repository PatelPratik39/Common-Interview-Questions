package BST;

public class LCA2 {
    static  class Node{
        int data;
        Node left,right;
       public Node(int data){
            this.data = data;
           this.left = this.right = null;
        }
    }

    private Node lca2 ( Node root, int n1, int n2 ) {
//        base case
        if( root == null) return null;
        if(root.data < n1 && root.data < n2) return lca2(root.right,n1,n2);
        if(root.data > n1 && root.data > n2) return lca2(root.left, n1, n2);

        return root;
    }


    public static void main ( String[] args ) {

        LCA2 tree = new LCA2();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        int n1 =10, n2 =14;

        Node t = tree.lca2(root, n1, n2);
        if(t != null){
            System.out.println("LCA of " + n1 + " and " + n2
                    + " is " + t.data);
        } else {
            System.out.println(" LCA not found!!");
        }


    }


}
