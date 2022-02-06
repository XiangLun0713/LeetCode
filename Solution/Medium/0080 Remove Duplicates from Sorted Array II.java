class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return 1;
        int count = 2;
        for (int i = 2, j = 2; i < nums.length; i++) {
            if (nums[j - 2] != nums[i]) {
                nums[j] = nums[i];
                j++;
                count++;
            }
        }
        return count;
    }
}
