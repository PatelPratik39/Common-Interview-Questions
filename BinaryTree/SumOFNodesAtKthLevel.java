package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOFNodesAtKthLevel {

    public static int sumAtKthLevel(TreeNode root, int K){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList <>();
        queue.add(root);
        int level = 0;
        int sum = 0;

         while(!queue.isEmpty()){
             int size = queue.size();
             sum = 0;
//          iterate over the size of the tree nodes
             for(int i=0; i < size; i++){
                TreeNode node = queue.poll();

                if(level == K){
                    sum += node.data;
                }
//                add left and right child to the queue
                 if(node.left != null){
                     queue.add(node.left);
                 }
                 if(node.right != null){
                     queue.add(node.right);
                 }
             }
//             if we have passed the Kth Level, return the sum
             if(level == K){
                 return sum;
             }
             level++;
         }
         return 0;
    }

    public static void main ( String[] args ) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

//        lets take K =2
        int K= 2;
        int sum = sumAtKthLevel(root,K);
        System.out.println("Sum Of Node at Kth Level "+ K + " is " + sum);
    }

}
