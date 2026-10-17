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
    boolean result = true;

    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }

        findDif(root);
        // findRightDepth(root.right, 1);

        return result;

    }

    public int findDif(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // if(root.left == null && root.right == null) {
        //     leftDepth = Math.max(leftDepth, level);
        //     return;
        // }

      int l = findDif(root.left);
      int r = findDif(root.right);

      int diff = Math.abs(l-r);

      if(diff > 1) {
        result = false;
      }

        return( 1 + Math.max(l, r));
    }

}