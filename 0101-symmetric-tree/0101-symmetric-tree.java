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
    public boolean isSymmetric(TreeNode root) {
       return checkSymmetric(root, root);
    }

    public static boolean checkSymmetric(TreeNode p, TreeNode q){
        if(p == null) {
            return true;
        }

        if((p == null && q != null) || (p != null && q == null)){
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        boolean checkLeft = checkSymmetric(p.left, q.right);
        boolean checkRight = checkSymmetric(p.right, q.left);

        if(checkLeft == true && checkRight == true) {
            return true;
        }else {
            return false;
        }
    }
}