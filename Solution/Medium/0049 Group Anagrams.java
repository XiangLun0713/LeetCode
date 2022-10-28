class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String s : strs) {
            String temp = encode(s);
            hashMap.putIfAbsent(temp, new ArrayList<>());
            hashMap.get(temp).add(s);
        }
        for (String key : hashMap.keySet()) {
            result.add(hashMap.get(key));
        }
        return result;
    }
    
    private String encode(String s) {
        char[] res = new char[26];
        for (char c : s.toCharArray()) {
            res[c - 'a']++;
        }
        return String.valueOf(res);
    }
}
