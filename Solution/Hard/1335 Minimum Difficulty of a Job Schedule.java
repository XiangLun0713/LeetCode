class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;
        int[][] memo = new int[d + 1][jobDifficulty.length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(jobDifficulty, d, 0, memo);        
    }
    
    private int dfs(int[] arr, int d, int index, int[][] memo) {
        if (d == 1) {
            int max = arr[index];
            for (int i = index + 1; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = index; i < arr.length - d + 1; i++) {
            max = Math.max(max, arr[i]);
            if (memo[d - 1][i + 1] == -1) {
                int subsequentMin = dfs(arr, d - 1, i + 1, memo);
                memo[d - 1][i + 1] = subsequentMin;
                min = Math.min(min, max + subsequentMin);
            } else {
                min = Math.min(min, max + memo[d - 1][i + 1]);
            }
        }
        return min;
    }
}
