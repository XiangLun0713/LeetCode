class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] flight :flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            graph[u].add(new int[]{v, price});
        }

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int currNode = poll[0];
                int currCost = poll[1];
                int stops = poll[2];

                if(stops > k) {
                    continue;
                }
                for(int[] next : graph[currNode]) {
                    int nextNode = next[0];
                    int nextPrice = next[1];

                    if(currCost + nextPrice < dist[nextNode] && stops <= k) {
                        dist[nextNode] = currCost + nextPrice;
                        queue.offer(new int[]{nextNode, dist[nextNode], stops+1});
                    }
                }
            }
        }
        if(dist[dst] != Integer.MAX_VALUE) {
            return dist[dst];
        }
        return -1;
    }
}
