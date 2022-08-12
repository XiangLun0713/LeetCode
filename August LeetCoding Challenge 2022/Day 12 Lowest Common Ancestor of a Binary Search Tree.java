/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pointer = root;
        while (pointer != null) {
            if (p.val > pointer.val && q.val > pointer.val) {
                pointer = pointer.right;
            } else if (p.val < pointer.val && q.val < pointer.val) {
                pointer = pointer.left;
            } else {
                return pointer;
            }
        }
        return null;
    }
}
