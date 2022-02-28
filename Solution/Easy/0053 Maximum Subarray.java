class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum = nums[0], preSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(preSum < 0) {
                preSum = 0;
            }
            preSum += nums[i];
            sum = Math.max(sum, preSum);
        }
        return sum;
    }
}
