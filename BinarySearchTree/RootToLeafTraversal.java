package BinarySearchTree;

//Root to leaf traversal


import java.util.ArrayList;

public class RootToLeafTraversal {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

//    insert the values into Tree
    public static Node insert( Node root, int val){
//        base case
        if(root == null){
            root = new Node(val);
            return root;
        }
//        if a root is greater than a values[] element then insert into left side of a tree
        if(root.data > val){
            root.left = insert(root.left, val);
        } else {
//            if a root is less than a value the insert value into the right side of the tree.
            root.right = insert(root.right, val);
        }
        return root;
    }
//    Print helper function to print all the Paths through iteration
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i< path.size(); i++){
            System.out.print(path.get(i) + " --> ");
        }
        System.out.println();
    }


//    print the path to leaf after inserting the data intot Tree
    public static void printPathRoot2Leaf( Node root, ArrayList<Integer> path ){
//        base case for null node check
        if(root == null){
            return;
        }
        path.add(root.data);  //add the root data to the Array list path
//        if node is leaf
        if(root.left == null && root.right == null){
//            print a path because we need to move further to check for node
            printPath(path);
        }else{
//            recursive function to create a path
            printPathRoot2Leaf(root.left, path);
            printPathRoot2Leaf(root.right,path);
        }
//        if we reach at leaf node and need to go back, o need to remove current node to traverse back
        path.remove(path.size()-1);
    }

    public static void main ( String[] args ) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;   // initialize the root node as null;
//        let's insert the elements to the tree
        for(int i =0; i< values.length; i++){
            root = insert(root, values[i]);
        }
        printPathRoot2Leaf(root, new ArrayList<>());
    }
}
