/*

    Remove all leaf nodes from the binary search tree.
    given a binary search tree and we want to delete the leaf nodes from the binary search tree.

    Input: 20 10 5 15 30 25 35
    Output: In order before Deleting the leaf node
         5 10 15 20 25 30 35
          In order after Deleting the leaf node
         10 20 30

        This is the binary search tree where we
        want to delete the leaf node.
              20
           /     \
          10      30
         /  \    /  \
       5     15 25   35

      After deleting the leaf node, the binary
      search tree looks like
              20
           /     \
          10      30

          Time Complexity = O(n)
          Space Complexity = O(h)
 */

package BST;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class RemoveAllLeafNodes {

    private static Node removeLeafNodes(Node node) {
        if (node == null) return null;

        // Recursively remove leaf nodes from left and right subtrees
        node.left = removeLeafNodes(node.left);
        node.right = removeLeafNodes(node.right);

        // If the current node is a leaf, return null to remove it
        if (node.left == null && node.right == null) return null;

        return node;
    }

    // Function to print the tree in-order for verification
    private static void inOrderTraversal(Node node) {
        if (node == null) return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    // Function to insert a node into the BST
    private static Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (data < root.data) root.left = insert(root.left, data);
        if (data > root.data) root.right = insert(root.right, data);

        return root;
    }

    public static void main(String[] args) {
        int[] values = {20, 10, 5, 15, 30, 25, 35};
        Node root = null;

        // Insert nodes into the BST
        for (int value : values) {
            root = insert(root, value);
        }

        System.out.println("Inorder before Deleting the leaf nodes:");
        inOrderTraversal(root);
        System.out.println();

        // Remove leaf nodes
        root = removeLeafNodes(root);

        System.out.println("Inorder after Deleting the leaf nodes:");
        inOrderTraversal(root);
        System.out.println();
    }
}
