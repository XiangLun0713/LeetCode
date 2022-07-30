class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] filter = new int[26];
        for (String word : words2) {
            int[] temp = countFreq(word);
            for (int i = 0; i < 26; i++) {
                filter[i] = Math.max(filter[i], temp[i]);
            }
        } 
        
        for (String word : words1) {
            int[] temp = countFreq(word);
            int i = 0;
            for (; i < 26; i++) {
                if (temp[i] < filter[i]) break;
            }
            if (i == 26) result.add(word);
        }
        return result;
    }
    
    private int[] countFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
