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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        levelOrder(root, list, q);

        return list;
    }

    public static void levelOrder(TreeNode root, List<List<Integer>> list, Queue<TreeNode> q) {

        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {

            int levelCount = q.size();

            ArrayList<Integer> tempArr = new ArrayList<>();

            while (levelCount > 0) {

                TreeNode t = q.poll();

                if (level % 2 == 0) {
                    tempArr.add(0, t.val); // tempArr.add(index, val) -> if we have [10, 20] and the use it like tempArr.add(0, 5); then it becomes [5, 10, 20 ]  it means the 5 is append at index 0 and the lat element which is at index 0 move to index 1 so for all time it is used like appending elements from starting of the List 
                } else {
                    tempArr.add(t.val);
                }

                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }

                levelCount--;
            }

            list.add(new ArrayList(tempArr));
            level++;

        }

        return;
    }
}