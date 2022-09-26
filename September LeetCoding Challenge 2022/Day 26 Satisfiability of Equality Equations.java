class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] unionFind = new int[26];
        for (int i = 0; i < 26; i++) {
            unionFind[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') 
                unionFind[find(unionFind, equation.charAt(0) - 'a')] = find(unionFind, equation.charAt(3) - 'a');
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && find(unionFind, equation.charAt(0) - 'a') == find(unionFind, equation.charAt(3) - 'a'))
                return false; 
        }
        return true;
    }
    private int find(int[] unionFind, int x) {
        return (unionFind[x] == x) ? x : find(unionFind, unionFind[x]);
    }
}
