class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int cost : costs) {
            pq.offer(cost);
        }
        int count = 0;
        while (coins > 0 && !pq.isEmpty()) {
            coins -= pq.poll();
            if (coins >= 0) count++;
        }
        return count;
    }
}
