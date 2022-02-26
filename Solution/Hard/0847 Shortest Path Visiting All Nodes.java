class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) return 0;

        int n = graph.length;
        int endingMask = (1 << n) - 1;
        boolean[][] seen = new boolean[n][endingMask];
        ArrayList<int[]> queue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, 1 << i});
            seen[i][1 << i] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            ArrayList<int[]> nextQueue = new ArrayList<>();
            for (int[] currPair : queue) {
                for (int res : graph[currPair[0]]) {
                    int nextMask = currPair[1] | (1 << res);
                    if (nextMask == endingMask) return steps + 1;
                    if (!seen[res][nextMask]) {
                        seen[res][nextMask] = true;
                        nextQueue.add(new int[]{res, nextMask});
                    }
                }
            }
            queue = nextQueue;
            steps++;
        }
        return -1;
    }
}
