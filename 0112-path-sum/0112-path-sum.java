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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sum(root, 0, targetSum);
    }

    public boolean sum(TreeNode root, int sum, int t) {
        if(root == null) {
            return false;
        }

        sum += root.val;

        if(root.left == null && root.right == null) {
            if(sum == t) {
                return true;
            }else {
                return false;
            }
        }

        boolean i = sum(root.left, sum, t);
        boolean j = sum(root.right, sum, t);

            if(i || j) {
                return true;
            }else {
                return false;
            }
    }
}