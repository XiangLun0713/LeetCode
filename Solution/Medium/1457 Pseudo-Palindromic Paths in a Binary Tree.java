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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int path) {
        int val = root.val;
        path ^= (1 << root.val);

        int count = 0;
        if (root.left == null && root.right == null){
            // check whether path in binary has only one 1 bit 
            return (path == (path & -path)) ? 1 : 0;    
        }
        if (root.left != null) count += dfs(root.left, path);
        if (root.right != null) count += dfs(root.right, path);

        return count;
    }
}
