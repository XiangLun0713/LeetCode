class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[k];
        int preSum = 0;
        for (int num : nums) {
            preSum += (num % k + k) % k;
            mods[preSum % k]++;
        }
        int result = mods[0];
        for (int mod : mods) {
            result += (mod * (mod - 1)) / 2;
        }
        return result;
    }
}
