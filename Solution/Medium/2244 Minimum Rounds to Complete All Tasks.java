class Solution {
    public int minimumRounds(int[] tasks) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int task : tasks) {
            hashMap.put(task, hashMap.getOrDefault(task, 0) + 1);
        }
        for (int key : hashMap.keySet()) {
            int val = hashMap.get(key);
            if (val == 1) return -1;
            count += (val + 2) / 3;
        }
        return count;
    }
}
