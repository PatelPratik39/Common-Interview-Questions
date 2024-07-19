package BinaryTree;

import java.util.*;

import static BinaryTree.createNode.BinaryTree.*;

public class createNode {

//    let's create a node first
    static class Node {
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
//    Node Create a Binary Search tree
    static class BinaryTree {
//        setting up initial index value as Null means -1
        static int idx= -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
//           recursively, create a new node that uses index values from a node array.
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);  //passing nodes in buildsTree method and store it into left side of Node.
            newNode.right = buildTree(nodes); //passing nodes in buildsTree method and store it into right side of Node.

            return newNode;
        }

//        Pre-Order Traversal from root node
    /*
    Time Complexity is O(n) because we traversing each node one by one.

     */
        public static void preOrder(Node root){

            if(root == null){
                return;
            }
            System.out.print(root.data + " -> ");
            preOrder(root.left);
            preOrder(root.right);
        }

//      InOrder Traversal
    /*
        Time Complexity will be O(n)

     */
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " -> ");
            inOrder(root.right);
        }

    //      PostOrder Traversal
    /*
        Time Complexity will be O(n) -> Linear order

     */
        public static void postOrder(Node root){
            if(root == null){
                return ;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " -> ");
        }

    //      Level Order Traversal
    /*
        Time Complexity will be O(n)
     */

        public static void levelOrder(Node root){
            if(root == null){
                return ;
            }
//            create a Queue object using LinkedList for solid implementation
            Queue<Node> queue = new LinkedList();
//            initial root node and null to print new line for leveling BFS
            queue.add(root);
            queue.add(null);
//            run a loop until queue gets empty
            while(!queue.isEmpty()){
                Node currNode = queue.remove();
                if(currNode == null){
                    System.out.println();
//                    this condition will check if queue is completely empty
                    if(queue.isEmpty()){
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.println(currNode.data);
                    if (currNode.left != null){
                        queue.add(currNode.left);
                    }
                    if(currNode.right != null){
                        queue.add(currNode.right);
                    }
                }
            }
        }
        //        Count of Node
//    Time Complexity will be O(n)
        public static int countOfNodes(Node root){

            if(root ==null){
                return 0;
            }
            int leftNode = countOfNodes(root.left);
            int rightNode = countOfNodes(root.right);

            return leftNode + rightNode + 1;
        }
    }


    public static void main ( String[] args ) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes); // calling buildTree(node) method and storing into tree root od node
        System.out.print("1. Root Node : ");
        System.out.println(root.data);
        System.out.print("2. Pre Order Traversal : ");// print all the data from
        preOrder(root);
        System.out.println(" ");
        System.out.print("3. In Order Traversal : ");
        inOrder(root);
        System.out.println( " ");
        System.out.print("4. Post Order Traversal : ");
        postOrder(root);
        System.out.println( " ");
        System.out.print("4. Level Order Traversal : ");
        levelOrder(root);

//        count the nodes
        System.out.println("5. Count The Nodes : " + countOfNodes(root));

    }
}
