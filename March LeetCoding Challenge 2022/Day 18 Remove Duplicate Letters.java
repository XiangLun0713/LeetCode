class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            lastIndex[arr[i] - 'a'] = i;
        }

        Deque<Character> deque = new ArrayDeque<>();
        deque.push(arr[0]);
        visited[arr[0] - 'a'] = true;
        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            if (!visited[c - 'a']) {
                while (!deque.isEmpty() && c < deque.peek() && lastIndex[deque.peek() - 'a'] > i) {
                    visited[deque.pop() - 'a'] = false;
                }
                deque.push(c);
                visited[c - 'a'] = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for (char res : deque) {
            result.insert(0, res);
        }
        return result.toString();
    }
}
