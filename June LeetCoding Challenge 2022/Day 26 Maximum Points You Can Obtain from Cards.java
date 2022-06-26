class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0, sum = 0;
        // populate the max & sum with the sum of the first k element
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = sum;
        int n = cardPoints.length;
        // slide the window to the left (rotate operation) & keep track of max score
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[k - 1 - i];
            sum += cardPoints[n - 1 - i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
