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
    int result = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return result;
        }   

        return findMax(root);
        // return result;
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findMax(root.left);
        int right = findMax(root.right);

        return Math.max(left, right) + 1;
    }
}
