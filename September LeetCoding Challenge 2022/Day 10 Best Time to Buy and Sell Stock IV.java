class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE / 2);
        Arrays.fill(sell, Integer.MIN_VALUE / 2);
        buy[0] = -prices[0];
        sell[0] = 0;
        
        for (int i = 1; i < n; i++) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = Math.max(sell[i], res);
        }
        return res;
    }
}
