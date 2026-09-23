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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        fun(root, arr);

        return arr;
    }

    public static void fun(TreeNode root, ArrayList<Integer> arr) {

        if(root == null ) {
            return;
        }

        fun(root.left, arr);
        fun(root.right, arr);

        arr.add(root.val);

        return;
    }
}