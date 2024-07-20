package BinarySearchTree;

public class BSTCreation {

//    create Node first
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
//    create insert function to insert Node
    public static Node insert(Node root, int val){
//        let's check if root present or null
        if (root == null) {
            root = new Node(val);
            return root;
        }
//        comparision
        if(root.data > val){
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    //     now create Inorder traversal function to check TRee set correctly or not
    public static void inOrder(Node root){
        if(root ==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main ( String[] args ) {
        int values[] = {5,1,3,4,2,7};
//        Initialize Node as Null
        Node root = null;

//        iterate over values[] array
        for(int i = 0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
    }
}
