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
        int result = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }


        StringBuilder str = new StringBuilder();

        fun(root, str);

        return result;
    }

    public void fun(TreeNode root, StringBuilder str) {
        if(root == null) {
            return;
        }

        str.append(root.val);

        if(root.left == null && root.right == null) {
            result += Integer.parseInt(str.toString());
            return;
        }

        fun(root.left, str);
        if(root.left != null) {
            str.deleteCharAt(str.length() - 1);
        }
        fun(root.right, str);
        if(root.right != null) {
            str.deleteCharAt(str.length() - 1);
        }

        return;
    }
}