class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<String> set = new HashSet<>();
        
        for (int i = 1; i < 10; i++) {
            dfs(set, n, k, i, String.valueOf(i));
        }

        int index = 0;
        int[] result = new int[set.size()];
        for (String s : set) {
            result[index++] = Integer.parseInt(s);
        }
        return result;
    }
    
    private void dfs(Set<String> set, int n, int k, int currNum, String s) {
        if (n == 1) {
            set.add(s);
            return;
        }
        
        if (currNum + k <= 9) dfs(set, n - 1, k, currNum + k, s + (currNum + k));
        if (currNum - k >= 0) dfs(set, n - 1, k, currNum - k, s + (currNum - k));
    }
}
