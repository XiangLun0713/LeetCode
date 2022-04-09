class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer>[] arr = new List[nums.length + 1];
        for (int res : nums) {
            hashMap.put(res, hashMap.getOrDefault(res, 0) + 1);
        }
        for (int key : hashMap.keySet()) {
            int freq = hashMap.get(key);
            if (arr[freq] == null) {
                arr[freq] = new ArrayList<>();
                arr[freq].add(key);
            } else {
                arr[freq].add(key);
            }
        }

        int[] result = new int[k];
        for (int i = arr.length - 1, j = 0; i >= 0; i--) {
            if (arr[i] == null) continue;
            while (!arr[i].isEmpty()) {
                if (j < k) {
                    result[j] = arr[i].remove(0);
                    j++;
                }
            }
            if (j == k) {
                break;
            }
        }
        return result;
    }
}
