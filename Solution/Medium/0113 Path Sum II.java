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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        traverse(root, result, new ArrayList<>(), targetSum, 0);
        return result;
    }
    
    private void traverse(TreeNode root, List<List<Integer>> result, List<Integer> path, int targetSum, int prevSum) {
        int currSum = prevSum + root.val;
        path.add(root.val);
        
        if (root.left == null && root.right == null && currSum == targetSum) {
            result.add(path);
            return;
        } 
        
        if (root.left != null) traverse(root.left, result, new ArrayList<>(path), targetSum, currSum);
        if (root.right != null) traverse(root.right, result, new ArrayList<>(path), targetSum, currSum);
    }
}
