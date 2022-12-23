class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
        for (int i = 0; i < prices.length; i++) {
            int prevSold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
