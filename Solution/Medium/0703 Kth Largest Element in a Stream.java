class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(Arrays.stream(nums).boxed().toList());

        while (queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
            return queue.peek();
        } else {
            int res = queue.peek();
            if (val <= res) {
                return res;
            } else {
                queue.poll();
                queue.offer(val);
                return queue.peek();
            }
        }
    }
}

