//Level Order Search - Breadth First Search

package lastMinuteCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public Node insert(Node root, int value){
        if(root == null) {
            return new Node(value);
        } else if( value <= root.data){
            root.left = insert(root.left, value);
        } else{
            root.right = insert(root.right, value);
        }
        return root;

    }
    private void levelOrderTraversal ( Node root ) {
        if(root == null) return;

        Queue<Node> queue = new LinkedList <>();   //keep track of nodes at current level
        queue.add(root);

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();   //remove() but it throw an error like NoSuchElementException and poll returns null
            System.out.print(currentNode.data + " "); //process current node data

//            enqueue (add) the left child if it exists
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }

    }

    public static void main ( String[] args ) {

        Scanner scanner  =new Scanner(System.in);
        Solution tree = new Solution();

//        Node root = new Node(1);
        Node root = null;

        int nodes = scanner.nextInt();

        for(int i=0; i < nodes; i++){
            int value= scanner.nextInt();
            root = tree.insert(root,value);
        }

//        root.right = new Node(2);
//        root.right.right = new Node(5);
//        root.right.right.left = new Node(3);
//        root.right.right.right = new Node(6);
//        root.right.right.left.right = new Node(4);
//
        tree.levelOrderTraversal(root);
    }


}
