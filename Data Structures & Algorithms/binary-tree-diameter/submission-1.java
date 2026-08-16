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

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    private int getLongest(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getLongest(root.left);
        int right = getLongest(root.right);

        return Math.max(left, right) + 1;
    }
 }
