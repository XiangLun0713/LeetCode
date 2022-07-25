/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<Integer> result;
    
    public List<Integer> preorder(Node root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }
    
    private void traverse(Node root) {
        if (root == null) return;
        result.add(root.val);
        List<Node> children = root.children;
        while (!children.isEmpty()) {
            traverse(children.remove(0)); 
        }
    }
}
