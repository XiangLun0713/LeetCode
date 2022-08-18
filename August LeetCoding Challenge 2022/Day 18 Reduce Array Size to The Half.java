class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : arr) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        int size = arr.length;
        int halfSize = arr.length / 2;
        int result = 0;
        
        List<Integer> freqList = new ArrayList<>(hashMap.values());
        Collections.sort(freqList, Collections.reverseOrder());
        
        for (int freq : freqList) {
            if (size <= halfSize) break;
            size -= freq;
            result++;
        }
        
        return result';
    }
}
