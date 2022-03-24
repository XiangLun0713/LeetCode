class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int res : nums) {
            if (hashMap.containsKey(res)) {
                hashMap.put(res, hashMap.get(res) + 1);
            } else {
                hashMap.put(res, 1);
            }
        }
        for (int res : hashMap.keySet()) {
            HashMap<Integer, Integer> map = new HashMap<>(hashMap);
            map.put(res, map.get(res) - 1);
            List<Integer> path = new ArrayList<>();
            path.add(res);
            dfs(nums, result, path, map);
        }
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, HashMap<Integer, Integer> map) {
        if (nums.length == path.size()) {
            result.add(path);
        } else {
            for (int key : map.keySet()) {
                if (map.get(key) > 0) {
                    HashMap<Integer, Integer> hashMap = new HashMap<>(map);
                    hashMap.put(key, hashMap.get(key) - 1);
                    List<Integer> temp = new ArrayList<>(path);
                    temp.add(key);
                    dfs(nums, result, temp, hashMap);
                }
            }
        }
    }
}
