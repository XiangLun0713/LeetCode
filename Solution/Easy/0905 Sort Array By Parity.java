class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        for (int res : nums) {
            if (res % 2 != 0) break;
            i++;
        }
        
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        return nums;
    }
}
