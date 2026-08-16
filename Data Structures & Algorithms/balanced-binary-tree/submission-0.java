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
    // dfs: return the height of left & right of a root
    // need extra
    // why need returns this for root? because the global result can be checked if height of both diff is less than 1

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        helper(root);

        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (Math.abs(left - right) > 1) {
            result = false;
        }

        return Math.max(left, right) + 1;
    }
}
