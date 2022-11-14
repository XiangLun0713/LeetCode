class Solution {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private int count = 0;
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            union(stones[i][0], ~stones[i][1]);
        }
        return n - count;
    }
    
    private int find(int x) {
        if (hashMap.putIfAbsent(x, x) == null) {
            count++;
        }
        if (hashMap.get(x) != x) {
            hashMap.put(x, find(hashMap.get(x)));
        }
        return hashMap.get(x);
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            hashMap.put(x, y);
            count--;
        }
    } 
}
