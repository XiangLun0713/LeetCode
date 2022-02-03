class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hash Map:
        // Key = element in nums
        // Value = index of the element in nums
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                return new int[]{i, hashMap.get(complement)};
            }
        }
        return null;
    }
}
