class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n - 1], maxProfit = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        return maxProfit;
    }
}
