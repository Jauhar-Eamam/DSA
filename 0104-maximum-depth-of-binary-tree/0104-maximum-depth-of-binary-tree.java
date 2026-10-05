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
    int depth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        findDepth(root, 1);

        return depth;
    }

    public void findDepth(TreeNode root, int level) {
        if(root == null) {
            return ;
        }

        if(root.left == null && root.right == null) {
            depth = Math.max(depth, level);
            return;
        }

        findDepth(root.left, level+1);
        findDepth(root.right, level+1);

        return;
    }
}