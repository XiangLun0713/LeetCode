class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (int num : hashMap.values()) {
            if (!set.add(num)) return false;
        }
        return true;
    }
}
