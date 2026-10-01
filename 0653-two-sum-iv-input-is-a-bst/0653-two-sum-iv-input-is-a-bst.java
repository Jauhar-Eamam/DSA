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
    Stack<TreeNode> stk1 = new Stack<>();
    Stack<TreeNode> stk2 = new Stack<>();
    public boolean findTarget(TreeNode root, int k) {
        TreeNode t = root;

        while(t != null){
            stk1.push(t);
            t = t.left;
        }

        t = root;

        while(t != null) {
            stk2.push(t);
            t = t.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while(i != null && j != null && i != j && i.val < j.val){
            int sum = i.val + j.val;

            if(sum == k) {
                return true;
            }else if(sum > k) {
                j = getBig();
            }else if(sum < k) {
                i = getSmall();
            }
        }

        return false;

    }

    public TreeNode getSmall() {
        if(stk1.isEmpty()) {
            return null;
        }

        TreeNode small = stk1.pop();

        TreeNode rightChild = small.right;

        while(rightChild != null) {
            stk1.push(rightChild);
            rightChild = rightChild.left;
        }

        return small;
    }

    public TreeNode getBig() {
        if(stk2.isEmpty()) {
            return null;
        }

        TreeNode big = stk2.pop();
        TreeNode leftChild = big.left;

        while(leftChild != null) {
            stk2.push(leftChild);

            leftChild = leftChild.right;
        }

        return big;
    }
}