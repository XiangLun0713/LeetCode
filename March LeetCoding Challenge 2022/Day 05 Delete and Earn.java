class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list);

        int earn1 = 0, earn2 = 0, prevNum = -1;
        for (int key : list) {
            int currVal = key * hashMap.get(key);
            if (prevNum != key - 1) {
                earn1 = earn2;
                earn2 += currVal;
            } else {
                int temp = Math.max(earn1 + currVal, earn2);
                earn1 = earn2;
                earn2 = temp;
            }
            prevNum = key;
        }
        return earn2;
    }
}
