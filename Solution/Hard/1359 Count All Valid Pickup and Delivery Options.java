class Solution {
    public int countOrders(int n) {
        long temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            temp *= 2 * i - 1;
            temp %= 1_000_000_007;
        }
        return (int) temp;
    }
}
