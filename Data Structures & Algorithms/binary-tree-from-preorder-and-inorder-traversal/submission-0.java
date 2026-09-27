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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(0, preorder.length - 1, preorder, inorder, map);
    }

    int index = 0;

    private TreeNode helper(int left, int right, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[index];
        TreeNode root = new TreeNode(rootValue);

        index++;

        root.left = helper(left, map.get(rootValue) - 1, preorder, inorder, map);
        root.right = helper(map.get(rootValue) + 1, right, preorder, inorder, map);
        
        return root;
    }
}
