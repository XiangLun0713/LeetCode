class Solution {
    public int numSquares(int n) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (square > n) break;
            list.add(square);
        }
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int square : list) {
                    if (curr + square > n) break;
                    else if (curr + square == n) return count;
                    if (!visited.contains(curr + square)) {
                        queue.offer(curr + square);
                        visited.add(curr + square);
                    }
                }
            }
        }
        return -1;
    }
}
