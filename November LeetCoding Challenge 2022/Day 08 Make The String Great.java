class Solution {
    public String makeGood(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.push('#');
        for (char c : s.toCharArray()) {
            if (isBad(c, deque.peekLast())) deque.removeLast();
            else deque.offerLast(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString().substring(1);
    }

    private boolean isBad(char c1, char c2) {
        return Character.isUpperCase(c1) ?
                c2 == Character.toLowerCase(c1):
                c2 == Character.toUpperCase(c1);
    }
}
