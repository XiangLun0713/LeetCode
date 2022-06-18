class WordFilter {
    private HashMap<String, Integer> hashMap;

    public WordFilter(String[] words) {
        hashMap = new HashMap<>();
        
        for(int w = 0; w < words.length; w++){
            for(int i = 0; i <= 10 && i <= words[w].length(); i++){
                for(int j = 0; j <= 10 && j <= words[w].length(); j++){
                    hashMap.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return (hashMap.containsKey(prefix + "#" + suffix))? hashMap.get(prefix + "#" + suffix) : -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
