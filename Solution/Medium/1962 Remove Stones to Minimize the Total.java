class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) pq.offer(pile);
        while (k-- > 0) {
            int curr = pq.poll();
            pq.offer(curr - curr / 2);
        }
        int sum = 0;
        for (int pile : pq) {
            sum += pile;
        }
        return sum;
    }
}
