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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<String> l1 = new ArrayList<>();
        getString(root, l1);
        List<String> l2 = new ArrayList<>();
        getString(subRoot, l2);
        
        String s1 = "," + String.join(",", l1) + ",";
        String s2 = "," + String.join(",", l2) + ",";

        return s1.contains(s2);
    }

    private void getString(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("#");
            return;
        }

        list.add("" + root.val);
        
        getString(root.left, list);
        getString(root.right, list);
    }


}
