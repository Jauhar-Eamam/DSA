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
    List<List<Integer>> result = new ArrayList<>();

    int val;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null ) {
            return result;
        }
        ArrayList<Integer> arr = new ArrayList<>();

        // arr.add(root.val);

        findSum(root, targetSum, arr, 0);

        return result;
    }

    public void findSum(TreeNode root, int target, ArrayList<Integer> arr, int sum) {
        if (root == null) {
            arr.add(0);
            return;
        }

        sum += root.val;

        arr.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(arr));
            }

            return;
        }

        findSum(root.left, target, arr, sum);

        if(arr.size() > 1){
        arr.remove(arr.size() - 1);
        }

        findSum(root.right, target, arr, sum);
        if(arr.size() > 1 ) {
        arr.remove(arr.size() - 1);
        }

        return;
    }
}
