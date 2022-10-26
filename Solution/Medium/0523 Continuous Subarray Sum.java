class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(){{put(0, 0);}};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (hashMap.containsKey(remainder) && hashMap.get(remainder) < i) return true;
            hashMap.putIfAbsent(remainder, i + 1);
        }
        return false;
    }
}
