class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.offerLast('#');
        for (char c : s.toCharArray()) {
            if (deque.peekLast() == c) deque.removeLast();
            else deque.offerLast(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString().substring(1);
    }
}
