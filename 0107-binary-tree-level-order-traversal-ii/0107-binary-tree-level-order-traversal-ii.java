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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        fun(root, q, res);
        return res;
    }

    public static void fun(TreeNode root, Queue<TreeNode> q, List<List<Integer>> res) {

        q.add(root);

        while (!q.isEmpty()) {
            int valCount = q.size();

            ArrayList<Integer> tempArr = new ArrayList<>();

            while (valCount > 0) {
                TreeNode t = q.poll();

                tempArr.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                valCount--;
            }
            res.add(0, new ArrayList(tempArr));

        }

        return;
    }
}