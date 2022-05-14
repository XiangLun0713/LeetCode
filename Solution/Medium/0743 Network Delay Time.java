class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        
        HashMap<Integer, List<Edge>> hashMap = new HashMap<>();
        for (int[] arr : times) {
            hashMap.putIfAbsent(arr[0], new ArrayList<>());
            hashMap.get(arr[0]).add(new Edge(arr[1], arr[2]));
        }

        int count = 0, time = 0;
        queue.offer(new Edge(k, 0));
        while (count != n && !queue.isEmpty()) {
            Edge curr = queue.poll();
            time = curr.weight;
            if (visited[curr.dest - 1]) continue;
            visited[curr.dest - 1] = true;
            List<Edge> list = hashMap.get(curr.dest);
            if (list != null) {
                for (Edge edge : list) {
                    queue.offer(new Edge(edge.dest, edge.weight + curr.weight));
                }
            }
            count++;
        }
        
        for (boolean b : visited) {
            if (!b) {
                return -1;
            }
        }
        
        return time;
    }
}
class Edge {
    int dest, weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}
