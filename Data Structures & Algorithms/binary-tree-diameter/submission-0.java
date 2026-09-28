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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        } 

        getDeepest(root);

        return max;
    }

    private int getDeepest(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDeepest(root.left);
        int right = getDeepest(root.right);

        if (root.left != null && root.right != null) {
            int result = left + right + 1;
        }

        return result;
    }
}
