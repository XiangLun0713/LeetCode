class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 1) return 1;

        Comparator<int[]> comparator = (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        };

        Arrays.sort(envelopes, comparator);
        int dp[] = new int[n];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) index = - (index + 1);
            dp[index] = envelope[1];
            if (index == len) len++;
        }
        return len;
    }
}
