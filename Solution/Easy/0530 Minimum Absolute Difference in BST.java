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
    private int minAbsDiff = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minAbsDiff;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        minAbsDiff = Math.min(minAbsDiff, Math.abs(root.val - prev));
        prev = root.val;
        traverse(root.right);
    }
}
