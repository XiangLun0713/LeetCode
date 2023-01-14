class Solution {
    private int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Arrays.fill(parent, -1);
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        char[] result = new char[baseStr.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) (find(baseStr.charAt(i) - 'a') + 'a');
        }
        return String.valueOf(result);
    }

    private int find(int x) {
        if (parent[x] == -1) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            parent[Math.max(x, y)] = Math.min(x, y);
    }
}
