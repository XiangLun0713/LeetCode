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
    public TreeNode pruneTree(TreeNode root) {
        return has1Subtree(root) ? root : null;
    }
    private boolean has1Subtree(TreeNode root) {
        if (root == null) return false;
        
        boolean result = (root.val == 1);
        
        if (root.left != null) {
            if (has1Subtree(root.left)) {
                result = true;
            } else {
                root.left = null;
            }
        }
        if (root.right != null) {
            if (has1Subtree(root.right)) {
                result = true;
            } else {
                root.right = null;
            }
        }
        
        return result;
    }
}
