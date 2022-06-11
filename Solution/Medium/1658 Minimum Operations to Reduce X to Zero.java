class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;
        if (target < 0) return -1;
        if (target == 0) return nums.length;
        
        int start = 0, sum = 0, maxLen = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                if (sum == target) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
                sum -= nums[start++];
            }
        }
        return (maxLen == 0) ? -1 : nums.length - maxLen;
    }
}
