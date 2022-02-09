class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int res : nums) {
            if (!hashMap.containsKey(res)) {
                hashMap.put(res, 1);
            } else {
                hashMap.put(res, hashMap.get(res) + 1);
            }
        }
        int count = 0;
        if (k > 0) {
            for (int res : hashMap.keySet()) {
                if (hashMap.containsKey(res + k)) {
                    count++;
                }
                if (hashMap.containsKey(res - k)) {
                    count++;
                }
            }
            return count / 2;
        } else {
            for (int res : hashMap.keySet()) {
                if (hashMap.get(res) > 1) {
                    count++;
                }
            }
            return count;
        }
    }
}
