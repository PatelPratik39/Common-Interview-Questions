/*
        Inorder Successor in Binary Search Tree


Time Complexity = O(h)
Space complexity = O(1)

 */

package BST;

public class InorderSuccessorBST {

    private static Node findInOrderSuccessor ( Node root, Node node ) {
        if(node == null) return null;
        // Case 1: Node has a right subtree
        if(node.right != null) return findMin(node.right);

        // Case 2: No right subtree, find the nearest ancestor for which given node is in left subtree
        Node successor = null;
        Node current = root;

        while(current != null){
            if(node.data < current.data){
                successor =current;
                current = current.left;
            } else if(node.data > current.data){
                current = current.right;
            } else {
                break;
            }
        }
        return successor;
    }

    private static Node findMin ( Node node ) {
        Node current = node;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    private static Node findNode ( Node root, int value ) {
        Node current = root;
        while(current != null){
            if(value < current.data) current = current.left;
            else if(value > current.data) current = current.right;
            else return current;
        }
        return null;
    }

    private static Node insert ( Node root, int data ) {
        if(root == null) return  new Node(data);
        if(data < root.data) root.left = insert(root.left,data);
        if(data > root.data) root.right = insert(root.right, data);
        return root;
    }

    public static void main ( String[] args ) {
        int[] values = {20, 8, 22, 4, 12, 10, 14};
        Node root = null;

        // Insert nodes into the BST
        for (int value : values) {
            root = insert(root, value);
        }

        int target = 10;
        Node targetNode = findNode(root, target);
        Node successor = findInOrderSuccessor(root, targetNode);

        if (successor != null) {
            System.out.println("In-order successor of " + target + " is " + successor.data);
        } else {
            System.out.println("In-order successor of " + target + " does not exist.");
        }
    }



}


