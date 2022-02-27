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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0});

        int width = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int initIndex = 0, endIndex = 0;
            for (int i = 0; i < size; i++) {
                Object[] curr = queue.poll();
                assert curr != null;
                TreeNode currNode = (TreeNode) curr[0];
                int currIndex = (Integer) curr[1];
                if (i == 0) {
                    initIndex = currIndex;
                }
                if (i == size - 1) {
                    endIndex = currIndex;
                }

                if (currNode.left != null) {
                    queue.offer(new Object[]{currNode.left, 2 * currIndex + 1});
                }
                if (currNode.right != null) {
                    queue.offer(new Object[]{currNode.right, 2 * currIndex + 2});
                }
            }
            width = Math.max(width, endIndex - initIndex + 1);
        }
        return width;
    }
}
