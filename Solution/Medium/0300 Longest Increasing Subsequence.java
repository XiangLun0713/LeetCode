class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int maxCount = Integer.MIN_VALUE;
        int[] LIS = new int[nums.length];
        LIS[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            LIS[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
            maxCount = Math.max(LIS[i], maxCount);
        }
        return maxCount;
    }
}
