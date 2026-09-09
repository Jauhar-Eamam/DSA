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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();

        fun(root, nodeList, 0);

        return nodeList;
    }

    public static void fun(TreeNode root, List<List<Integer>> nodeList, int indx) {
        if(root == null) {
            return;
        }



        if(nodeList.size() <= indx){
            nodeList.add(new ArrayList<>());
        }

        fun(root.left, nodeList, indx+1);
        nodeList.get(indx).add(root.val);
        fun(root.right, nodeList, indx+1);
        return;
    }
}