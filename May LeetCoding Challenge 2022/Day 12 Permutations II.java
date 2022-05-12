// Using Depth-First-Search with recurssion and backtracking
// Using HashMap to prevent duplication when there are duplicated number in the nums array
// HashMap {Key => elements in nums array; Value => frequency of that element in nums array};

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        dfs(hashMap, new ArrayList<>());
        return result;
    }

    private void dfs(HashMap<Integer, Integer> freqMap, List<Integer> prePath) {
        if (freqMap.isEmpty()) {
            result.add(prePath);
        } else {
            for (int key : freqMap.keySet()) {
                List<Integer> path = new ArrayList<>(prePath);
                HashMap<Integer, Integer> hashMap = new HashMap<>(freqMap);

                int value = hashMap.get(key);
                if (value == 1) {
                    hashMap.remove(key);
                } else {
                    hashMap.put(key, value - 1);
                }
                path.add(key);
                dfs(hashMap, path);
            }
        }
    }
}
