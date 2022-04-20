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
class BSTIterator {
    private Deque<TreeNode> deque = new ArrayDeque<>();
    
    public BSTIterator(TreeNode root) {
        traverseLeft(root);
    }
    
    public int next() {
        TreeNode curr = deque.pop();
        if (curr.right != null) traverseLeft(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !deque.isEmpty();
    }
    
    private void traverseLeft(TreeNode root) {
        while (root != null) {
            deque.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
