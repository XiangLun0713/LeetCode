class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int res : nums) {
            if (!hashMap.containsKey(res)) {
                hashMap.put(res, 1);
            } else {
                hashMap.put(res, hashMap.get(res) + 1);
            }
        }
        int result = 0, prevFreq = 0;
        for (int key : hashMap.keySet())
            if (hashMap.get(key) > (nums.length / 2) && hashMap.get(key) > prevFreq) {
                prevFreq = hashMap.get(key);
                result = key;
            }
        return result;
    }
}
