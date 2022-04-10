class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : ops) {
            if (s.charAt(0) == 'C') {
                deque.pop();
            } else if (s.charAt(0) == 'D') {
                deque.push(deque.peek() * 2);
            } else if (s.charAt(0) == '+') {
                int i = deque.pop();
                int j = deque.peek();
                deque.push(i);
                deque.push(i + j);
            } else {
                deque.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        for (int res : deque) {
            sum += res;
        }
        return sum;
    }
}
