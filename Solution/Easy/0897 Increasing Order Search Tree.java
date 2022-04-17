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
    private TreeNode treeNode = new TreeNode(-1);
    private TreeNode pointer = treeNode;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        pointer.right = new TreeNode(root.val);
        pointer = pointer.right;
        increasingBST(root.right);
        return treeNode.right;
    }
}
