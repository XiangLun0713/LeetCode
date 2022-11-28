class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        Arrays.sort(matches, (a, b) -> b[1] - a[1]);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int[] match : matches) {
            hashMap.put(match[1], hashMap.getOrDefault(match[1], 0) + 1);
            hashMap.putIfAbsent(match[0], 0);
        }
        for (int key : hashMap.keySet()) {
            int val = hashMap.get(key);
            if (val == 0) result.get(0).add(key);
            else if (val == 1) result.get(1).add(key);
        }
        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return result;
    }
}
