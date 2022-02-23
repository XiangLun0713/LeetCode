class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
                count++;
            }
        }
        return count;
    }
}
