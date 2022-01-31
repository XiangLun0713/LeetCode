class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (var res : accounts) {
            int sum = 0;
            for (var res2 : res) {
                sum += res2;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
