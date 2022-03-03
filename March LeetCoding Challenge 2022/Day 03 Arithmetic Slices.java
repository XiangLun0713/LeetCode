class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int[] dp = new int[nums.length - 1];
        int count = 0, totalCount = 0;
        dp[0] = nums[1] - nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = nums[i + 1] - nums[i];
            if (dp[i] == dp[i - 1]) {
                count++;
            } else {
                if (count > 0) {
                    totalCount += factorial(count + 1) / (2 * factorial(count - 1));
                    count = 0;
                }
            }
        }
        if (count > 0) totalCount += factorial(count + 1) / (2 * factorial(count - 1));
        return totalCount;
    }

    private long factorial(long n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
