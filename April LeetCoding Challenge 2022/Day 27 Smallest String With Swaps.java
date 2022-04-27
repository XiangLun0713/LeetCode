// Using union find algorithm (union by rank)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind unionFind = new UnionFind(s.length());

        // union all the vertex
        for (List<Integer> list : pairs) {
            unionFind.union(list.get(0), list.get(1));
        }

        // key => root; value => indices
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // find the root(parent) for each index in ascending order
            int root = unionFind.find(i);
            // add the components into hashMap where key is the root and values is the indices
            hashMap.putIfAbsent(root, new ArrayList<>());
            hashMap.get(root).add(i);
        }

        char[] chars = s.toCharArray();
        for (var indices : hashMap.values()) {
            // for each set of indices, we extract the characters from the string s and sort the characters
            List<Character> characters = new ArrayList<>();
            for (var index : indices) {
                characters.add(chars[index]);
            }
            Collections.sort(characters);

            // replace the string with sorted characters at their respective indices
            for (int i = 0; i < indices.size(); i++) {
                chars[indices.get(i)] = characters.get(i);
            }
        }
        return String.valueOf(chars);
    }
}

// Union Find (Union by rank -> always attach smaller depth tree under the root of the deeper tree)
class UnionFind {
    // keep track of the root for a particular vertex
    private int[] root;
    // keep track of the rank for a particular vertex
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = i;
        }
    }

    // find the root of a given vertex
    public int find(int x) {
        if (root[x] == x) {
            // if the root of a vertex is itself, meaning that it has not yet been union before
            // we return the vertex itself
            return x;
        }
        // if the root of a vertex is not itself,
        // find the root(parent) of the vertex recursively, and update the root of the current vertex
        return root[x] = find(root[x]);
    }

    // union two component together
    public void union(int x, int y) {
        // find the root of the two vertices
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] >= rank[rootY]) {
                // if the rank of x is greater than the rank of y,
                // we attach y under x, as we are using union by rank
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            } else {
                // if the rank of y is greater than the rank of x,
                // we attach x under y, as we are using union by rank
                root[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
        }
    }
}
