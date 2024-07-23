package BinarySearchTree;

/*
Find a path from root to leaf
 */

import java.util.ArrayList;

public class PathFromRootToLeaf {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

//    insert the data into node
    public static Node insert( Node root, int val ){
//        check if ode is null create a new node as root
        if(root == null){
            root = new Node(val);
            return root;
        }
//        using recursive function, we can add tree data into the left and right subtree node

        if(root.data > val) {   //if root data is greater than the value
            root.left = insert(root.left,val); // The value will be inserted to the left subtree
        }else {  //otherwise
            root.right = insert(root.right,val); //the value will be inserted to the right subtree
        }
        return root;  //after all, return root;
    }

//    find a possible path from root to leaf

//    Helper function for to print a path
    public static void printPath(ArrayList<Integer> path){

//        iterate over the arraylist to print each element for the path

        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + " --> ");
        }
        System.out.println();
    }

    public static void printPathFromRootToLeaf( Node root, ArrayList<Integer> path ){
//        base case that checks that root is null or not
        if(root == null){
            return;
        }
        path.add(root.data);  //add the root data to the Array list path
//        now check if leaf node is present or not using null check
        if(root.left == null && root.right == null){
//            if the node is leaf node means there are no more children for a node then print path
            printPath(path); //helper method to print a path
        } else { // if there is no leaf node or a current node has any data then
            printPathFromRootToLeaf(root.left, path);   //recursive method
            printPathFromRootToLeaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main ( String[] args ) {
        Node root = null;
        int values[] = {8,5,3,1,4,6,10,11,14, 15, 13};
//        insert the data into a tree using insertmethof
        for(int i =0; i< values.length; i++){
            root = insert(root, values[i]);
        }
        printPathFromRootToLeaf(root, new ArrayList<>());
    }
}
