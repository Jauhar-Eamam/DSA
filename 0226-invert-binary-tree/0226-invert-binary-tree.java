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
    public TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return root;
        }
        Queue<TreeNode> tempNode = new LinkedList<>();

        fun(root, tempNode);

        return root;
    }

    public static void fun(TreeNode p, Queue<TreeNode> tempNode){

        if(p == null ) {
            return;
        }

        tempNode.add(p.left);
        p.left = p.right;
        p.right = tempNode.poll();
        fun(p.left, tempNode);
        fun(p.right , tempNode);

        return;
    }
}