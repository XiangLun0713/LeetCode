class Solution {
    public int maxProfit(int[] prices) {
        int lastMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < lastMin) {
                lastMin = price;
            } else if (price - lastMin > maxProfit) {
                maxProfit = price - lastMin;
            }
        }
        return maxProfit;
    }
}
