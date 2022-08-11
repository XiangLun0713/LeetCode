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
    private long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }
    private boolean traverse(TreeNode root) {
        if (root == null) return true;
        if (!traverse(root.left)) return false;
        if (prev >= root.val) {
            return false;
        }
        prev = root.val;
        return traverse(root.right);
    }
}
