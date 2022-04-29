// Using Breath-First-Search method & graph colouring
class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        // red => -1; no color => 0; blue => 1
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // offer the node to queue if it is not yet coloured
            if (color[i] == 0) queue.offer(i);
            int count = 0;
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int j = 0; j < n; j++) {
                    int curr = queue.poll();
                    for (int res : graph[curr]) {
                        if (color[res] == 0) queue.offer(res);
                        if (count % 2 == 0) {
                            if (color[res] == 1) return false;
                            color[res] = -1;
                        } else {
                            if (color[res] == -1) return false;
                            color[res] = 1;
                        }
                    }
                }
                count++;
            }
        }
        return true;
    }
}
