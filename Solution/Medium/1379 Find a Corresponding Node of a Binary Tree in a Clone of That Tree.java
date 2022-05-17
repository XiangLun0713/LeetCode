/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Using Breadth-First-Search(BFS)
// Using two queues to solve the follow up question
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queueCloned = new LinkedList<>();
        Queue<TreeNode> queueOri = new LinkedList<>();
        
        queueOri.offer(original);
        queueCloned.offer(cloned);
        
        while(!queueCloned.isEmpty()) {
            int size = queueCloned.size();
            for (int i = 0; i < size; i++) {
                TreeNode currOri = queueOri.poll();
                TreeNode currCloned = queueCloned.poll();
                
                if (currOri == target) return currCloned;
                if (currOri.left != null) {
                    queueOri.offer(currOri.left);
                    queueCloned.offer(currCloned.left);
                }
                if (currOri.right != null) {
                    queueOri.offer(currOri.right);
                    queueCloned.offer(currCloned.right);
                }
            }
        }
        return null;
    }
}
