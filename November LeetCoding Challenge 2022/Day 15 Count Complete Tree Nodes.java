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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int count = 0;
            int n = queue.size();
             for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                count++;
                if (curr.right != null) queue.offer(curr.right);
                else count += (Math.max(count - 1, 0) * 2) + 1;
                if (curr.left != null) queue.offer(curr.left);
            }
            result += count;
        }
        
        return result;
    }
}
