class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int ans = -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (possibleCapacity(mid, weights, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean possibleCapacity(int capacity, int[] weights, int days) {
        int sum = 0;
        int count = 1;
        for (int weight : weights) {
            if (sum + weight > capacity) {
                sum = weight;
                count++;
            } else {
                sum += weight;
            }
        }
        return count <= days;
    }
}
