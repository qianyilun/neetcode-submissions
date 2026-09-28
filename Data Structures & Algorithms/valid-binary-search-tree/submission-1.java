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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root, root.val);
    }

    private boolean helper(TreeNode root, int maxVal) {
        if (root == null) {
            return true;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right && )

        return true;
    }
}
