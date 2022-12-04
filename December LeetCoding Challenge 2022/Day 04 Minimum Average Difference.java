class Solution {
    public int minimumAverageDifference(int[] nums) {
        long n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long min = Integer.MAX_VALUE;
        long minIdx = -1;
        long preSum = 0;
        for (int i = 0; i < n - 1; i++) {
            preSum += nums[i];
            long temp = Math.abs((preSum / (i + 1)) - ((totalSum - preSum) / (n - i - 1)));
            if (temp < min) {
                min = temp;
                minIdx = i;
            }
        }
        return (int) (((totalSum / n) < min) ? n - 1 : minIdx);
    }
}
