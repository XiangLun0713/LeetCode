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
    long totalSum = 0, maxProduct = 0;
    public int maxProduct(TreeNode root) {
        totalSum = sum(root);
        sum(root);
        return (int) (maxProduct % (1e9+7));
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;
        int currSum = root.val + sum(root.left) + sum(root.right);
        maxProduct = Math.max(maxProduct, (totalSum - currSum) * currSum);
        return currSum;
    }
}
