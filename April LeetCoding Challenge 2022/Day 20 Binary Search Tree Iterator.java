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
    private List<Integer> list;
    private int index;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        traverse(root);
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        if (index < list.size()) return true;
        return false;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
