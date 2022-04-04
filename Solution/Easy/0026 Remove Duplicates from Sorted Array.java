class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > curr) {
                nums[j] = nums[i];
                curr = nums[i];
                j++;
            }
        }
        return j;
    }
}
