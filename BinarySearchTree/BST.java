package BinarySearchTree;

public class BST {

//    create Node Structure
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
//
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
//            left subtree
           root.left =  insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }
        return root; //returninmg root
    }
//    now check if our insert function works correctly or not lets travers the node using Inorder traversal  function
    public static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main ( String[] args ) {
        int values[] = {5,1,3,4,2,7};
        Node root = null; //initialize root with null value

//      iterate over values[] an array to traverse the tree
        for(int i = 0; i < values.length; i++){
            root = insert(root,values[i]);
        }

//        lets call inorder() method
        inorder(root);
        System.out.println();
    }
}
