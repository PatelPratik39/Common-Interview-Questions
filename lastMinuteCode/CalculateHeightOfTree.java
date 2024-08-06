package lastMinuteCode;

import java.util.Scanner;

public class CalculateHeightOfTree {

    private int getHeight ( Node root ) {
        if(root == null) return -1;   // base case, if root node is not exist then return -1.
        else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    private Node insert ( Node root, int data ) {
        if(root == null) return new Node(data);   //base case
        else if(data <= root.data) root.left = insert(root.left,data);
        else insert(root.right,data);
        return root;
    }

    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        CalculateHeightOfTree tree = new CalculateHeightOfTree();
        Node root = null;

//        int[] nodeValues = {3, 5, 2, 1, 4, 6, 7};
//        for(int value : nodeValues){
//            root = tree.insert(root,value);
//        }

        int values = sc.nextInt();
        for(int i=0; i < values; i++){
            int value = sc.nextInt();
            root = tree.insert(root, value);
        }

//        get the height of the Tree
        int height = tree.getHeight(root);
        System.out.println(height);

    }
}

