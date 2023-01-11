class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, Node> hashMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(i, new Node(i));
        }
        for (int[] edge : edges) {
            hashMap.get(edge[0]).children.add(edge[1]);
            hashMap.get(edge[1]).children.add(edge[0]);
        }
        for (int i = 0; i < hasApple.size(); i++) {
            hashMap.get(i).hasApple = hasApple.get(i);
        }
        return countTime(hashMap, visited, 0);
    }

    private int countTime(HashMap<Integer, Node> hashMap, Set<Integer> visited, int curr) {
        int count = 0;
        if (visited.contains(curr)) return count;
        visited.add(curr);
        for (int child : hashMap.get(curr).children) {
            count += countTime(hashMap, visited, child);
        }
        return ((hashMap.get(curr).hasApple || count > 0) && curr != 0) ? count + 2: count;
    }
}

class Node {
    int val;
    List<Integer> children;
    boolean hasApple;

    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
