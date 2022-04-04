class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] cache = populateCache(s);
            String res = String.valueOf(cache);
            if (!hashMap.containsKey(res)) {
                hashMap.put(res, new ArrayList<>(List.of(s)));
            } else {
                hashMap.get(res).add(s);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    private char[] populateCache(String s) {
        char[] cache = new char[26];
        for (char c : s.toCharArray()) {
            cache[c - 'a']++;
        }
        return cache;
    }
}
