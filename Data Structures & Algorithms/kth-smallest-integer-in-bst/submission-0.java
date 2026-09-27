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
    int index = 1;
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        helper(root.left, k);
        list.add(root.val);

        if (k == list.size()) {
            result = root.val;
            return;
        }
        
        helper(root.right, k);
    }
}
