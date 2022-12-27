class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        for (int i = 0; i < capacity.length; i++) {
            pq.offer(new Pair(capacity[i], rocks[i], capacity[i] - rocks[i]));
        }
        int count = 0;
        while (additionalRocks > 0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            if (additionalRocks >= curr.diff) {
                count++;
                additionalRocks -= curr.diff;
            }
        }
        return count;
    }
}

class Pair {
    int capacity;
    int rocks;
    int diff;

    public Pair(int capacity, int rocks, int diff) {
        this.capacity = capacity;
        this.rocks = rocks;
        this.diff = diff;
    }
}
