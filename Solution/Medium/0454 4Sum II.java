class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        // key = sum of a pair, value = frequency of the sum
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();

        final int N = nums1.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sumOfPair1 = nums1[i] + nums2[j];
                int sumOfPair2 = nums3[i] + nums4[j];
                if (!hm1.containsKey(sumOfPair1)) {
                    hm1.put(sumOfPair1, 1);
                } else {
                    hm1.put(sumOfPair1, hm1.get(sumOfPair1) + 1);
                }
                if (!hm2.containsKey(sumOfPair2)) {
                    hm2.put(sumOfPair2, 1);
                } else {
                    hm2.put(sumOfPair2, hm2.get(sumOfPair2) + 1);
                }
            }
        }
        
        for (int sum : hm1.keySet()) {
            if (hm2.containsKey(-sum)) {
                count += hm1.get(sum) * hm2.get(-sum);
            }
        }
        return count;
    }
}
