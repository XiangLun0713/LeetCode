class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] cache = new int[nums.length + 1];
        int[] result = new int[2];
        for (int num : nums) cache[num]++;
        for (int i = 1; i < cache.length; i++) {
            if (cache[i] > 1) result[0] = i;
            if (cache[i] == 0) result[1] = i;
        }
        return result;
    }
}
