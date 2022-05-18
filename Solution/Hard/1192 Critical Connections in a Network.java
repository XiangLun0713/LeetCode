class Solution {
    private int timer = 0;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = createAdjacencyList(n, connections);
        boolean[] visited = new boolean[n];
        int[] timestamp = new int[n];
        DFS(-1,0, visited, timestamp, graph);
        return result;
    }

    private void DFS(int parent, int curr, boolean[] visited, int[] timestamp, List<List<Integer>> graph) {
        visited[curr] = true;
        timestamp[curr] = timer++;
        int currentTimeStamp = timestamp[curr];
        for (int edge : graph.get(curr)) {
            if (edge == parent) continue;
            if (!visited[edge]) DFS(curr, edge, visited, timestamp, graph);
            timestamp[curr] = Math.min(timestamp[curr], timestamp[edge]);
            if (currentTimeStamp < timestamp[edge]) result.add(Arrays.asList(curr, edge));
        }
    }

    private List<List<Integer>> createAdjacencyList(int n, List<List<Integer>> connections) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int edge1 = connection.get(0);
            int edge2 = connection.get(1);
            list.get(edge1).add(edge2);
            list.get(edge2).add(edge1);
        }
        return list;
    }
}
