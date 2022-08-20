class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        if (stations.length == 0) return -1;

        int stopCount = 0;
        int currPos = 0;
        int achievableDistance = startFuel;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (achievableDistance < target) {
            while (currPos < stations.length && stations[currPos][0] <= achievableDistance) {
                pq.offer(stations[currPos++][1]);
            }

            if (pq.isEmpty()) return -1;
            achievableDistance += pq.poll();
            stopCount++;
        }

        return stopCount;
    }
}
