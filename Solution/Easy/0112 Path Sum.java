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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // base case
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum == root.val) return true;
        
        // dfs traverse
        boolean result = false;
        if (root.left != null) result |= hasPathSum(root.left, targetSum - root.val);
        if (root.right != null) result |= hasPathSum(root.right, targetSum - root.val);
        
        return result;
    }
}
