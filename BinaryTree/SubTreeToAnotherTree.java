package BinaryTree;

public class SubTreeToAnotherTree {

    public boolean isSubTree(TreeNode mainTree, TreeNode subTree){
//        empty tree always be a subtree
        if (mainTree == null) return true;
//        mainTree should not be empty
        if (subTree == null) return false;

        if(isIdentical(mainTree, subTree)) return true;

        return isSubTree(mainTree.left, subTree) ||  isSubTree(mainTree.right, subTree);
    }

//    Helper method to check if two trees arw identical or not
    public boolean isIdentical(TreeNode mainTree, TreeNode subTree) {
        if(mainTree == null && subTree == null) return true;  //both the tree are emoty
        if(mainTree == null || subTree == null)return false;  //one tree is empty and other is not

//        Check if the current nodes match and the left and right subtrees match
        return (mainTree.data == subTree.data) && isIdentical(mainTree.left, subTree.left) && isIdentical(mainTree.right, subTree.right);
    }


    public static void main ( String[] args ) {
        SubTreeToAnotherTree check = new SubTreeToAnotherTree();

//        create Main Tree
        TreeNode mainTree = new TreeNode(3);
        mainTree.left = new TreeNode(4);
        mainTree.right = new TreeNode(5);
        mainTree.left.left = new TreeNode(1);
        mainTree.left.right = new TreeNode(2);
        mainTree.left.right.left = new TreeNode(0);
        mainTree.right.left = new TreeNode(6);
        mainTree.right.right = new TreeNode(7);
        mainTree.right.right.right= new TreeNode(8);
        System.out.println("Main Tree : " + mainTree.data);

//        create SubTree first
        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);
        subTree.right.left = new TreeNode(0);  //additional Node
        System.out.println("Sub Tree : " + subTree.data);

        boolean result = check.isSubTree(mainTree, subTree);
        System.out.println("Is Subtree a Subtree of mainTree ? " + result);

    }


}
