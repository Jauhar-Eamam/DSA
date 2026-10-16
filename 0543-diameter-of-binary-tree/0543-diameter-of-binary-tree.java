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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        fun(root);
        // RightFun(root.right, 1);

        return max;

    }

    // public void LeftFun(TreeNode root, int level) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     LeftFun(root.left, level + 1);
    //     if (root.left == null) {
    //         Lmax = Math.max(Lmax, level);
    //     }
    //     LeftFun(root.right, level + 1);
    //     if (root.right == null) {
    //         Lmax = Math.max(Lmax, level);
    //     }

    //     return;

    // }

    public int fun(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = fun(root.left);
        // if(root.left == null) {
        //     Rmax = Math.max(Rmax, level);
        // }
        int right = fun(root.right);
        // if(root.right == null) {
        //     Rmax = Math.max(Rmax, level);
        // }

        int sum = left + right;
        max = Math.max(sum, max);
        return (1 + Math.max(left, right));

    }
}