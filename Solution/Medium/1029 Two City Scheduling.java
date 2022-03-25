class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;
        int n = costs.length;
        int[] refunds = new int[n];
        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0];
            refunds[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refunds);
        for (int i = 0; i < n / 2; i++) {
            totalCost += refunds[i];
        }
        return totalCost;
    }
}
