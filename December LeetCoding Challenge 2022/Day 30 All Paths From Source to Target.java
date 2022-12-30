class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, graph, result, new ArrayList<>(List.of(0)));
        return result;
    }
    
    private void dfs(int node, int[][] graph, List<List<Integer>> result, List<Integer> path) {
        for (int child : graph[node]) {
            if (path.contains(child)) continue;
            List<Integer> temp = new ArrayList<>(path);
            temp.add(child);
            if (child == graph.length - 1)  {
                result.add(temp);
                continue;
            }
            dfs(child, graph, result, temp);
        }
    }
}
