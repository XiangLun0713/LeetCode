/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
        public Node connect (Node root){
            if (root == null) return null;
            if (root.left != null) {
                root.left.next = root.right;
            } else {
                return root;
            }
            branchConnect(root.left);
            branchConnect(root.right);
            return root;
        }
        private Node branchConnect (Node root){
            if (root.left != null) {
                root.left.next = root.right;
                branchConnect(root.left);
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                branchConnect(root.right);
            }
            return root;
        }
}
