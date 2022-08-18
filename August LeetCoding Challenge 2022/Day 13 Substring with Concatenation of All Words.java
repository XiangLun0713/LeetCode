class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int n = s.length();
        int numOfWord = words.length;
        int lenOfAWord = words[0].length();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n - numOfWord * lenOfAWord + 1; i++) {
            HashMap<String, Integer> seenMap = new HashMap<>();
            String currSubstring = s.substring(i, i + numOfWord * lenOfAWord);

            int j = 0;
            for (; j < numOfWord; j++) {
                String currWord = currSubstring.substring(j * lenOfAWord, (j + 1) * lenOfAWord);
                if (!wordMap.containsKey(currWord)) break;
                seenMap.put(currWord, seenMap.getOrDefault(currWord, 0) + 1);
                if (seenMap.get(currWord) > wordMap.get(currWord)) break;
            }

            if (j == numOfWord) result.add(i);
        }

        return result;
    }
}
