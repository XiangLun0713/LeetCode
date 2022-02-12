class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] word = Objects.requireNonNull(queue.poll()).toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char initialChar = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word[j]) continue;
                        word[j] = c;
                        if (String.valueOf(word).equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(String.valueOf(word))) {
                            queue.offer(String.valueOf(word));
                            set.remove(String.valueOf(word));
                        }
                    }
                    word[j] = initialChar;
                }
            }
            level++;
        }
        return 0;
    }

}
