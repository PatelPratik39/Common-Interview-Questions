package BinaryTree;

import java.util.Arrays;

// first create main class that contain main method and it will encapsulate all other classes

public class CreateNode1 {

//    create static class node
    static class Node{
        int data;
//        Node left, right;
        Node left = null;
        Node right = null;

//        lets initialize the node with given value like data and pass as parameter
        Node(int data){
            this.data = data;
//            left = right = null;
            this.right = null;
            this.left = null;
        }
    }
//    Create static class for BinaryTree creation

    static class BinaryTree{
        static  int index = -1; // static variable to traverse the array

        public static Node buildTree(int nodes[]){
            index++;  // incrementing index value

//            if the current node value is -1 then it returns null, means no node should be created
            if(nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]); //create a new Node with current value in the array
//            recursively build the left and right subtree
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;  //return new node each time
        }

    }

//    Create Node first using static Node class
    public static void main ( String[] args ) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        System.out.println(Arrays.toString(nodes));
//        let's instantiate BinaryTree class
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes); // call buildTree method to construct the tree and store the root node
        System.out.println(root.data); // print data of the root
    }
}
