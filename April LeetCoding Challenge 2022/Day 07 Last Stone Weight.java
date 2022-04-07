class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for(int res : stones) {
            queue.offer(res);
        }
        while (queue.size() > 1) {
            int i = queue.poll();
            int j = queue.poll();
            if (i != j) {
                queue.offer(i - j);
            }
        }
        Integer result = queue.poll();
        return (result == null)? 0 : result;
    }
}
