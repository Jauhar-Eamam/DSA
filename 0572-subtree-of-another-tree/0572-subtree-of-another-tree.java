/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return fun(root, subRoot);

    }

    public static boolean fun(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }

        if ((root == null && subRoot != null) ) {
            return false;
        }

        boolean leftTree = false;

        boolean rightTree = false;


        if (root.val == subRoot.val) {
         if(fun1(root, subRoot)){
            return true;
            }
        } 
           leftTree = fun(root.left, subRoot);
           rightTree = fun(root.right, subRoot);
        

        if(leftTree || rightTree) {
            return true;
        }else {
        return false;
        }
    }

    public static boolean fun1(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if ( (root == null || subRoot == null)) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        boolean leftCheck = fun1(root.left, subRoot.left);
        boolean rightCheck = fun1(root.right, subRoot.right);

        if (leftCheck == true && rightCheck == true) {
            return true;
        } else {
            return false;
        }

    }
}