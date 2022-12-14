class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < nums.length + 2; i++) {
            dp[i] = Math.max(nums[i - 2] + dp[i - 2], dp[i - 1]);
        }        
        return dp[nums.length + 1];
    }
}
