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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
        } else if (root1 == null && root2 != null) {
            root1 = new TreeNode(root2.val);
        }

        try {
            if (root1.left != null || root2.left != null) {
                root1.left = mergeTrees(root1.left, root2.left);
            }
        } catch (NullPointerException ignored) {
        }

        try {
            if (root1.right != null || root2.right != null) {
                root1.right = mergeTrees(root1.right, root2.right);
            }
        } catch (NullPointerException ignored) {
        }

        return root1;
    }
}
