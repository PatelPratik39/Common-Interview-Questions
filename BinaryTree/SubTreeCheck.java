package BinaryTree;

/*

 Problem statement = > lets check subtree of another tree
 Time Complexity will O(n *m) that is worst case where n is number of nodes from main tree
 and m stands for m number of subtree
 */

public class SubTreeCheck {

//    This function will check if S is subTree of T
    public boolean isSubTree(TreeNode T, TreeNode S){
//        an empty tree is always a subtree
        if(S == null) return true;
//        Non-empty tree can't be a subtree of an empty tree
        if(T == null) return false;

//        now let's check the main Tree root is equal to subtree root then return true
        if(isIdentical(T, S)) return true;

//        otherwise, check the left and right subtrees of main Tree of T
        return isSubTree(T.left, S) || isSubTree(T.right, S);
    }
//    Create a helper function to check if two trees are identical ot not!!
    public boolean isIdentical(TreeNode T, TreeNode S){
        if(T == null && S == null) return true;  // if both the trees are empty
        if(T == null || S == null) return false; // One tree is empty, the other is not

//        check if the current node match and the left and right subtree match
        return (T.data == S.data && isIdentical(T.left, S.left) && isIdentical(T.right, S.right));
    }

    public static void main ( String[] args ) {

//        create an object of SubTreeCheck class
        SubTreeCheck check = new SubTreeCheck();
//        create a Main tree
        TreeNode T = new TreeNode(3);
        T.left = new TreeNode(4);
        T.right = new TreeNode(5);
        T.left.left = new TreeNode(1);
        T.left.right = new TreeNode(2);
        T.left.right.left = new TreeNode(0);
        T.right.left = new TreeNode(6);
        T.right.right = new TreeNode(7);
        T.right.right.right = new TreeNode(8);
        System.out.println(" Main Tree : " + T.data);

//        Create a SubTree
        TreeNode S = new TreeNode(4);
        S.left = new TreeNode(1);
        S.right = new TreeNode(2);
        S.right.left = new TreeNode(0);
        System.out.println(" Sub Tree : " + S.data);

//        Now check id SubTree of S is a SubTree of main tree of T??
        boolean result = check.isSubTree(T, S);
        System.out.println("Is S a SubTree of T ?? : " + result);
    }
}
