class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 != 0) {
                num = num * 2;
            }
            min = Math.min(min, num);
            pq.offer(num);
        }
        int minDiff = Integer.MAX_VALUE;
        while (true) {
            int max = pq.poll();
            minDiff = Math.min(minDiff, max - min);
            if (max % 2 == 1)
                break;
            max = max / 2;
            min = Math.min(min, max);
            pq.offer(max);
        }
        return minDiff;
    }
}
