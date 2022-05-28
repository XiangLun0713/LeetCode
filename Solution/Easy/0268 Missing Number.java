class Solution {
    public int missingNumber(int[] nums) {
        int temp = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            temp ^= i;
            temp ^= nums[i];
        }
        return temp ^ i;
    }
}
