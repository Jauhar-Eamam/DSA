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

        ArrayList<Integer> currArr = new ArrayList<>();

        fun(root, nodeList, currArr, 0);

        return nodeList;
    }

    public static void fun(TreeNode root, List<List<Integer>> nodeList, ArrayList<Integer> currArr, int indx) {
        if(root == null) {
            return;
        }



        if(nodeList.size() <= indx){
            nodeList.add(new ArrayList(currArr));
        }

        fun(root.left, nodeList, currArr, indx+1);
        nodeList.get(indx).add(root.val);
        fun(root.right, nodeList, currArr, indx+1);
        return;
    }
}