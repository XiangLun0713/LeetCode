class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1 ? true : false;
        
        // using max heap to find the max num
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int) (b - a));

        // find total sum of the target array & populate the priority queue
        long totalSum = 0;
        for (int num : target) {
            totalSum += num;
            pq.offer((long) num);
        }

        // keep decreasing the max num in pq & check whether the queue is all 1's
        while (!pq.isEmpty()) {
            long i = pq.poll();
            totalSum -= i;

            if (i == 1 || totalSum == 1) return true;
            if (i < totalSum) return false;

            i %= totalSum;
            if (i == 0) return false;

            totalSum += i;
            pq.offer(i);
        }

        return true;
    }
}
