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
    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return list.get(k - 1);
    }
    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
