class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        String targetPattern = generatePattern(pattern);
        for (String word : words) {
            if (targetPattern.equals(generatePattern(word))) result.add(word);
        }
        return result;
    }
    
    private String generatePattern(String s) {
        char value = '1';
        StringBuilder pattern = new StringBuilder();
        char[] mappingArr = new char[26];
        for (char c : s.toCharArray()) {
            if (mappingArr[c - 'a'] == 0) {
                mappingArr[c - 'a'] = ++value;
            }
            pattern.append(mappingArr[c - 'a']);
        }
        return pattern.toString();
    }
}
