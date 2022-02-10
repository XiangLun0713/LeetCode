class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0, pre = 0;
        hashMap.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (hashMap.containsKey(pre - k)) {
                count += hashMap.get(pre - k);
            }
            if (hashMap.containsKey(pre)) {
                hashMap.put(pre, hashMap.get(pre) + 1);
            } else {
                hashMap.put(pre, 1);
            }
        }
        return count;
    }
}
