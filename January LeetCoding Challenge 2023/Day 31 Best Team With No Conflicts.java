class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];
        for (int i = 0; i < scores.length; i++) {
            players[i] = new int[] {ages[i], scores[i]};
        }
        Arrays.sort(players, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : b[0] - a[0]);
        
        int res = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int score = players[i][1];
            dp[i] = score;
            for (int j = 0; j < i; j++) {
                if (players[j][1] >= score) {
                    dp[i] = Math.max(dp[i], dp[j] + score);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
