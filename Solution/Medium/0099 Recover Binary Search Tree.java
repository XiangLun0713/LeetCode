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
    private int i = 0;
    public void recoverTree(TreeNode root) {
        traverse(root);
        Collections.sort(list);
        traverse2(root);
    }
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
    private void traverse2(TreeNode root) {
        if (root == null) return;
        traverse2(root.left);
        if (root.val != list.get(i)) {
            root.val = list.get(i);
        }
        i++;
        traverse2(root.right);
    }
}
