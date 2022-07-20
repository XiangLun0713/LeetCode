class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<String>> hashMap = new HashMap<>();
        for (String word : words) {
            char c = word.charAt(0);
            hashMap.putIfAbsent(c, new ArrayList<>());
            hashMap.get(c).add(word);
        }
        
        int count = 0;
        for (char c : s.toCharArray()) {
            List<String> list = hashMap.get(c);
            if (list == null) continue;
            hashMap.remove(c);
            for (String temp : list) {
                temp = temp.substring(1);
                if (temp.isEmpty()) {
                    count++;
                } else {   
                    hashMap.putIfAbsent(temp.charAt(0), new ArrayList<>());
                    hashMap.get(temp.charAt(0)).add(temp);
                }
            }
        }
        
        return count;
    }
}
