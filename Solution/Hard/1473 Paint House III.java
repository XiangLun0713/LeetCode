class Solution {
    private Integer[][][] memoize = new Integer[101][21][101];
    private final int MAX = (int) 1e8;
    private int m, n;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        int res = dfs(houses, cost, 0, 0, target);
        return res >= MAX ? -1 : res;
    }
    
    private int dfs(int[] houses, int[][] cost, int currIndex, int prevColor, int target) {
        if (currIndex == m || target < 0)
            return target == 0 ? 0 : MAX;
        
        if (memoize[currIndex][prevColor][target] != null)
            return memoize[currIndex][prevColor][target];
        
        if (houses[currIndex] != 0) { 
            int curColor = houses[currIndex];
            memoize[currIndex][prevColor][target] = dfs(houses, cost, currIndex + 1, curColor, target - (prevColor == curColor ? 0 : 1));
            return memoize[currIndex][prevColor][target];
        }
        
        int res = MAX;
        for (int curColor = 1; curColor <= n; curColor++) {
            res = Math.min(res, dfs(houses, cost, currIndex + 1, curColor, target - (prevColor == curColor ? 0 : 1)) + cost[currIndex][curColor - 1]);
        }
        memoize[currIndex][prevColor][target] = res;
        return res;
    }
}
