class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        
        int prevDiff = nums[1] - nums[0];
        int count = prevDiff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];
            if (currDiff > 0 && prevDiff <= 0 || currDiff < 0 && prevDiff >= 0) {
                count++;
                prevDiff = currDiff;
            }
        }
        
        return count;
    }
}
