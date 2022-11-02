class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        if (!set.contains(end)) return -1;
        
        int count = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) return count;;
                Set<String> possibleMutation = findNextMutations(curr, set, visited);
                for (String s: possibleMutation) {
                    queue.offer(s);
                }
            }
            count++;
        }
        return -1;
    }

    private Set<String> findNextMutations(String curr, Set<String> set, Set<String> visited) {
        Set<String> temp = new HashSet<>();
        for (String s : set) {
            if (visited.contains(s)) continue;
            if (oneCharDiff(curr, s)) {
                temp.add(s);
                visited.add(s);
            }
        }
        return temp;
    }
    
    private boolean oneCharDiff(String s1, String s2) {
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (flag) return false;
                else flag = true;
            }
        }
        return true;
    }
}
