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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> visited = new HashSet<>();
        return traverse(root, k, visited);
    }
    
    public boolean traverse(TreeNode root, int k, Set<Integer> visited) {
        if (root == null) return false;
        if (visited.contains(k - root.val)) return true;
        visited.add(root.val);
        return traverse(root.left, k, visited) || traverse(root.right, k, visited);
    }
}
