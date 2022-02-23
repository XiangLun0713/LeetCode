/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> hashMap = new HashMap<>();
        hashMap.put(node.val, new Node(node.val));
        dfs(node, hashMap);
        return hashMap.get(1);
    }
    
    private void dfs (Node node, HashMap<Integer, Node> hashMap) {
        for (var res : node.neighbors) {
            if (hashMap.containsKey(res.val)) {
                hashMap.get(node.val).neighbors.add(hashMap.get(res.val));
            } else {
                hashMap.put(res.val, new Node(res.val));
                hashMap.get(node.val).neighbors.add(hashMap.get(res.val));
                dfs(res, hashMap);
            }
        }
    }
}
