class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        HashMap<Integer, Node> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(i, new Node(i));
        }
        for (int[] edge : edges) {
            hashMap.get(edge[0]).children.add(edge[1]);
            hashMap.get(edge[1]).children.add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        return dfs(hashMap.get(source), visited, destination, hashMap);
    }

    private boolean dfs(Node root, Set<Integer> visited, int destination, HashMap<Integer, Node> hashMap) {
        for (int child : root.children) {
            if (visited.contains(child)) continue;
            if (child == destination) return true;
            visited.add(child);
            Node curr = hashMap.get(child);
            if (dfs(curr, visited, destination, hashMap)) return true;
        }
        return false;
    }
}

class Node {
    int val;
    List<Integer> children;
    
    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
