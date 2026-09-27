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

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }

        if (left >= root.val || right <= root.val) {
            return false;
        }

        boolean leftBoolean = helper(root.left, left, root.val);
        boolean rightBoolean = helper(root.right, root.val, right);

        return leftBoolean && rightBoolean;
    }
}
