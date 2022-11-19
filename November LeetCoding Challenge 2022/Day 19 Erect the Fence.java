class Solution {
    public int[][] outerTrees(int[][] points) {
        int n = points.length;
        if (n < 4) return points;
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        Stack<int[]> hull = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (hull.size() >= 2 && orient(hull.get(hull.size() - 2), hull.peek(), points[i]) > 0) {
                hull.pop();
            }
            hull.push(points[i]);   
        }
        hull.pop();
        for (int i = n - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orient(hull.get(hull.size() - 2), hull.peek(), points[i]) > 0) {
                hull.pop();
            }
            hull.push(points[i]);
        }
        HashSet<int[]> result = new HashSet<>(hull);
        return result.toArray(new int[result.size()][]);
    }
    
    private int orient(int[] p, int[] q, int[] r) {
        return ((q[1] - p[1]) * (r[0] - q[0])) - ((r[1] - q[1]) * (q[0] - p[0]));
    }
}
