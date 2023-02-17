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
    private TreeNode previous = null;
    private int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return min;
    }
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (previous != null) {
            min = Math.min(min, Math.abs(root.val - previous.val));
        }
        previous = root;
        traverse(root.right);
    }
}
