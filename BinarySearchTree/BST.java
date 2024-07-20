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

//    now Search the Key in BST
    public static boolean search(Node root, int key){
        if(root == null) return false;
//        1. comparison with Node root with a key
        if(root.data > key) return search(root.left, key);  // return left subtree
        if(root.data < key) return search(root.right, key); // return right subtree
        if(root.data == key) return true;

        return true;
    }

//    Delete Node
    /*
    Test case 1: No child (Leaf Node)
    Test Case 2: One Child
    Test Case 3: Two Children
     */

    public static Node delete(Node root, int val){
//        search a node first that we want to delete
        if(root.data > val){
            root.left = delete(root.left, val);
        } else if(root.data < val){
            root.right = delete(root.right, val);
        } else {
            //root.data == val
            if(root.left == root.right && root.right == null){
                return null;
            }
//            case 2 -> One Child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
//            case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main ( String[] args ) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null; //initialize root with null value

//      iterate over values[] an array to traverse the tree
        for(int i = 0; i < values.length; i++){
            root = insert(root,values[i]);
        }

//        lets call inorder() method
        inorder(root);
        System.out.println();

        if(search(root,3)){
            System.out.println("Found !!!");
        }else {
            System.out.println("What are your doing man!! Key, Not found!!!");
        }

        delete(root,11);
        inorder(root);
    }
}
