class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> seen = new HashSet<>();
        
        for (String word : words) {
            String transformation = "";
            for (char c : word.toCharArray()) {
                transformation += morse[c - 'a'];
            }
            seen.add(transformation);
        }
        
        return seen.size();
    }
}
