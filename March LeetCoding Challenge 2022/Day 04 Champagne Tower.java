class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0;
        double[] prev = {poured};
        for (int i = 0; i < query_row; i++) {
            int n = prev.length;
            double[] arr = new double[prev.length + 1];
            for (int j = 0; j < n; j++) {
                double exceed = Math.max((prev[j] - 1) / 2.0, 0);
                arr[j] += exceed;
                arr[j + 1] += exceed;
            }
            prev = arr;
        }
        return Math.min(1, prev[query_glass]);
    }
}
