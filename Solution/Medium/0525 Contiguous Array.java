class Solution {
    public int findMaxLength(int[] nums) {
        // key = count, value = index of first occurrence
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if (hashMap.containsKey(count)) {
                max = Math.max(max, i - hashMap.get(count));
            } else {
                hashMap.put(count, i);
            }
        }
        return max;
    }
}
