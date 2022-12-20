class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (visited.contains(curr)) continue;
                visited.add(curr);
                if (visited.size() == rooms.size()) return true;
                List<Integer> list = rooms.get(curr);
                for (int key : list) {
                    queue.offer(key);
                }
            }
        }
        return false;
    }
}
