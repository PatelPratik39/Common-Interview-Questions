package BinaryTree;

import java.util.Arrays;

public class CreateBinaryTreeNode {
//    create Node
    static class  Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
//    create a Binary tree
    static class BinaryTree{
        static int index = -1;

//        create a Tree method
        public static Node createNode(int nodes[]){
            index ++;
//            first check node value is -1 means its null
            if(nodes[index] == -1){
                return null;
            }
//            if (index >= nodes.length || nodes[index] == -1) {
//                return null;
//            }

            Node newNode = new Node(nodes[index]); // create a new node with current index
            newNode.left = createNode(nodes);
            newNode.right = createNode(nodes);

            return newNode;
        }

    // Method to perform an in-order traversal and print the tree
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
    }
    public static void main ( String[] args ) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        System.out.println(Arrays.toString(nodes));
        BinaryTree tree = new BinaryTree();

        //let's call buildTree method to construct a tree and store it in root node
        Node root = tree.createNode(nodes);
        System.out.println(root.data);
        System.out.println("In-order Traversal");
        tree.inOrderTraversal(root);
    }
}
