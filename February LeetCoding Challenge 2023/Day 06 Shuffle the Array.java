class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            result[idx] = nums[i];
            result[idx + 1] = nums[n + i];
            idx += 2;
        }
        return result;
    }
}
