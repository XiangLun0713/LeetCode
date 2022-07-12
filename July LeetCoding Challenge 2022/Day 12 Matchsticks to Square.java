class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) return false;
        int sum = IntStream.of(matchsticks).sum();
        if (sum % 4 != 0) return false;
        sortDescending(matchsticks);
        return dfs(matchsticks, new int[4], 0, sum / 4);
    }
    
    private boolean dfs(int[] matchsticks, int[] sums, int index, int target) {
        if (index == matchsticks.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }
        
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + matchsticks[index] > target) continue;
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, sums, index + 1, target)) return true;
            sums[i] -= matchsticks[index];
        }
        
        return false;
    }
    
    private void sortDescending(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
