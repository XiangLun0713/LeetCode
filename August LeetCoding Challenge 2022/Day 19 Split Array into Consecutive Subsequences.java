class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (freqMap.get(num) <= 0) continue;
            freqMap.put(num, freqMap.get(num) - 1);

            if (hashMap.containsKey(num) && hashMap.get(num) > 0) {
                hashMap.put(num, hashMap.get(num) - 1);
                hashMap.put(num + 1, hashMap.getOrDefault(num + 1, 0) + 1);
            } else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0) {
                freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                freqMap.put(num + 2, freqMap.get(num + 2) - 1);
                hashMap.put(num + 3, hashMap.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
