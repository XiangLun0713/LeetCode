class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        cache[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            int res = 0;
            for (int num : nums) {
                if (num <= i) res += cache[i - num];
            }
            cache[i] = res;
        }
        return cache[target];
    }
}
