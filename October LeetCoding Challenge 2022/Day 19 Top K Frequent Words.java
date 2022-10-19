class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (hashMap.containsKey(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
                list.add(word);
            }
        }
        list.sort((a, b) -> hashMap.get(a).equals(hashMap.get(b)) ? a.compareTo(b) : hashMap.get(b) - hashMap.get(a));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i));
        }
        return result;
    }
}
