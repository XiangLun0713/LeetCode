class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] modifiedTasks = new int[n][tasks[0].length];
        for (int i = 0; i < n; i++) {
            int[] task = tasks[i];
            modifiedTasks[i] = new int[]{i, task[0], task[1]};
        }
        Arrays.sort(modifiedTasks, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[2] != a[2]) ? a[2] - b[2] : a[0] - b[0]);
        int timeline = 1, idx = 0, resultIdx = 0;
        int[] result = new int[n];
        while (resultIdx < n) {
            while (idx < n && modifiedTasks[idx][1] <= timeline) {
                pq.offer(modifiedTasks[idx]);
                idx++;
            }
            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                result[resultIdx++] = curr[0];
                timeline += curr[2];
            } else {
                timeline = modifiedTasks[idx][1];
            }
        }
        return result;
    }
}
