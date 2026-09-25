/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode  ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return root;
        }

        fun(root, p, q);
        return ans;
    }

    public TreeNode fun(TreeNode root, TreeNode p, TreeNode q) {

        if((root.val == p.val )||( root.val == q.val))  {
            ans = root;
            return ans;
        }


        if(root.val > q.val && root.val > p.val) {
           return fun(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val) {
           return fun(root.right, p, q);
        }else if((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)) {
            ans = root;
        }
        return ans;
    }
}