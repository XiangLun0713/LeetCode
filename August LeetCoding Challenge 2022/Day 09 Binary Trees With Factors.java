class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        final long MOD = 1000_000_007;
        
        Arrays.sort(arr);
        
        long treeCount = 0;
        HashMap<Integer, Long> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            long count = 1;
            for (int num : hashMap.keySet()) {
                if (num * num == arr[i]) count += (hashMap.get(num) * hashMap.get(num)) % MOD;
                else if (hashMap.containsKey(arr[i] / num) && (arr[i] / num) * num == arr[i]) 
                    count += (hashMap.get(num) * hashMap.get(arr[i] / num)) % MOD;
            }
            hashMap.put(arr[i], count);
            treeCount = (treeCount + count) % MOD;
        }
        
        return (int) treeCount;
    }
}
