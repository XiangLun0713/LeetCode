class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        for (int i = 1; i < n; i++) {
            nums[i] = nums[deque.peekFirst()] + nums[i];

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();

            deque.offerLast(i);

            if (i - deque.peekFirst() >= k) deque.pollFirst();
        }

        return nums[n - 1];
    }
}
