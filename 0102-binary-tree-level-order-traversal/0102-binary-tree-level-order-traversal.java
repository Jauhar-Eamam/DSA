
// By using Queue 

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
            ArrayList<Integer> tempArr = new ArrayList<>();

            int qsize = q.size();

            while (qsize > 0) {
                TreeNode t = q.poll();
                tempArr.add(t.val);

                if (t.left != null) {
                    q.add(t.left);
                }

                if (t.right != null) {
                    q.add(t.right);
                }

                qsize--;
            }

            res.add(new ArrayList(tempArr));

        }

        return;
    }
}

// By using ArrayList Only

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> nodeList = new ArrayList<>();

//         fun(root, nodeList, 0);

//         return nodeList;
//     }

//     public static void fun(TreeNode root, List<List<Integer>> nodeList, int indx) {
//         if(root == null) {
//             return;
//         }

//         if(nodeList.size() <= indx){
//             nodeList.add(new ArrayList<>());
//         }

//         fun(root.left, nodeList, indx+1);
//         nodeList.get(indx).add(root.val);
//         fun(root.right, nodeList, indx+1);
//         return;
//     }
// }