class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        for (int res : numbers) {
            dfs(result, numbers, new ArrayList<>(), res);
        }
        return result;
    }

    private void dfs(List<List<Integer>> result, HashSet<Integer> numbers, List<Integer> path, int currentNumber) {
        HashSet<Integer> newNumbersSet = new HashSet<>(numbers);
        List<Integer> newPath = new ArrayList<>(path);
        newNumbersSet.remove(currentNumber);
        newPath.add(currentNumber);
        result.add(newPath);
        for (int res : newNumbersSet) {
            if (res > currentNumber) {
                dfs(result, newNumbersSet, newPath, res);
            }
        }
    }
}
