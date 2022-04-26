// Using Prim's Algorithm to find the Minimum Spanning Tree
// Using min heap that gives the point that gives the minimum cost
// Using a boolean array to track the visited node/to avoid redundancy
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Pair : key => cost, value => point's index in points array
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));
        boolean[] visited = new boolean[n];
        int cost = 0;
        int count = 0;

        minHeap.offer(new Pair<>(0, 0));
        while (count != n) {
            Pair<Integer, Integer> curr = minHeap.poll();
            while (visited[curr.getValue()]) {
                curr = minHeap.poll();
            }
            cost += curr.getKey();
            visited[curr.getValue()] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int[] targetPoint = points[i];
                    int[] currPoint = points[curr.getValue()];
                    minHeap.offer(new Pair<>(manhattanDistance(targetPoint[0], targetPoint[1], currPoint[0], currPoint[1]), i));
                }
            }
            count++;
        }
        return cost;
    }

    private int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
