class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        stack.push(new Pair<>('#', 0));
        for (char c : s.toCharArray()) {
            Pair<Character, Integer> pair = stack.peek();
            if (pair.key == c) {
                if (pair.value == k - 1) {
                    stack.pop();
                } else {
                    pair.value++;
                }
            } else {
                stack.push(new Pair<>(c, 1));
            }
        }

        String result = "";
        int n = stack.size();
        for (int i = 0; i < n - 1; i++) {
            Pair<Character, Integer> pair = stack.pop();
            for (int j = 0; j < pair.value; j++) {
                result = pair.key + result;
            }
        }
        return result;
    }
}

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
