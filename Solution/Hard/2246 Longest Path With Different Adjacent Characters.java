class Solution {
    private int max = 0;
    public int longestPath(int[] parent, String s) {
        HashMap<Integer, Node> hashMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            hashMap.put(i, new Node(i, s.charAt(i)));
        }
        for (int i = 1; i < parent.length; i++) {
            hashMap.get(parent[i]).children.add(i);
        }
        dfs(hashMap, 0);
        return max;
    }

    private int dfs(HashMap<Integer, Node> hashMap, int curr) {
        Node currNode = hashMap.get(curr);
        int longest = 0, secondLongest = 0;
        for (int child : currNode.children) {
            int len = dfs(hashMap, child);
            if (currNode.label != hashMap.get(child).label) {
                if (len > longest) {
                    secondLongest = longest;
                    longest = len;
                } else if (len > secondLongest) {
                    secondLongest = len;
                }
            }
        }
        max = Math.max(longest + secondLongest + 1, max);
        return longest + 1;
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
