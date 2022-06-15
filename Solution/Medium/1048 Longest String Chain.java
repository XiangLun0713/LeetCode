class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int result = 0;
        for (String word : words) {
            int best = 1;
            for (int i = 0; i < word.length(); i++) {
                String s = word.substring(0, i) + word.substring(i + 1);
                if (hashMap.containsKey(s)) {
                    best = Math.max(hashMap.get(s) + 1, best);
                }
            }
            hashMap.put(word, best);
            result = Math.max(result, best);
        }
        return result;
    }
}
