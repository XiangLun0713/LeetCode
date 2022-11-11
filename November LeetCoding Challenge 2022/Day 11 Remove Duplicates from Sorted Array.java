class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) continue;
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            prev = temp;
            index++;
        }
        return index;
    }
}
