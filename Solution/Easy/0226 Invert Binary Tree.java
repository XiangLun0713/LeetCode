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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invert(root);
        return root;
    }
    
    private void invert(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) invert(root.left);
        if (root.right != null) invert(root.right);
    }
}
