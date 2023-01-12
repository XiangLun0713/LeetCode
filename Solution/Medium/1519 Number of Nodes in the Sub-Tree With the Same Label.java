class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, Node> hashMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(i, new Node(i, labels.charAt(i)));
        }
        for (int[] edge : edges) {
            hashMap.get(edge[0]).children.add(edge[1]);
            hashMap.get(edge[1]).children.add(edge[0]);
        }
        int[] result = new int[n];
        countLabel(result, visited, hashMap, 0);
        return result;
    }

    private int[] countLabel(int[] result, Set<Integer> visited, HashMap<Integer, Node> hashMap, int curr) {
        int[] freq = new int[26];
        char label = hashMap.get(curr).label;
        freq[label - 'a'] = 1;
        if (!visited.add(curr)) return null;
        for (int child : hashMap.get(curr).children) {
            int[] temp = countLabel(result, visited, hashMap, child);
            if (temp == null) continue;
            for (int i = 0; i < 26; i++) {
                freq[i] += temp[i];
            }
        }
        result[curr] = freq[label - 'a'];
        return freq;
    }
}

class Node {
    int val;
    char label;
    List<Integer> children;

    public Node(int val, char label) {
        this.val = val;
        this.label = label;
        children = new ArrayList<>();
    }
}
