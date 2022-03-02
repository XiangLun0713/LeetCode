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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<ArrayList<TreeNode>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(p, q)));
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                ArrayList<TreeNode> curr = queue.poll();
                assert curr != null;
                TreeNode node1 = curr.get(0);
                TreeNode node2 = curr.get(1);
                if(node1 == null && node2 != null || node2 == null && node1 != null) return false;
                if(node1 == null) continue;

                if (node1.val == node2.val) {
                    if (node1.left != null || node2.left != null) {
                        queue.offer(new ArrayList<>(Arrays.asList(node1.left, node2.left)));
                    }
                    if (node1.right != null || node2.right != null) {
                        queue.offer(new ArrayList<>(Arrays.asList(node1.right, node2.right)));
                    }
                } else {
                    return false;
                }
            }

        }
        return true;

    }
}
