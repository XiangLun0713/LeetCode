class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];
        char[] arr = dominoes.toCharArray();
        
        // from left to right
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                force = n;
            } else if (arr[i] == 'L') {
                force = 0;
            }
            forces[i] = Math.max(force--, 0);
        }
        
        // from right to left
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                force = n;
            } else if (arr[i] == 'R') {
                force = 0;
            }
            forces[i] -= Math.max(force--, 0);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int forceAssert : forces) {
            sb.append((forceAssert < 0) ? "L" : ((forceAssert > 0) ? "R" : "."));
        }
        return sb.toString();
    }
}
