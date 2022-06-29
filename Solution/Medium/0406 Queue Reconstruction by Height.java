class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // populate the max-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for (int[] person : people) {
            pq.offer(person);
        }

        // reconstruct the queue
        List<int[]> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            list.add(curr[1], curr);
        }
        
        // return the queue
        return list.toArray(new int[people.length][]);
    }
}
