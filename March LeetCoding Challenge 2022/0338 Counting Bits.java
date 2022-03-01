class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i < result.length; i++) {
            int currVal= i;
            int count = 0;
            while (currVal > 0) {
                if ((currVal & 1) == 1) {
                    count++;
                }
                currVal >>= 1;
            }
            result[i] = count;
        }
        return result;
    }

}
