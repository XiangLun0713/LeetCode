class Solution {
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (k > 1) {
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        String res = s;
        for (int i = 0; i < n - 1; i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.compareTo(res) < 0) res = s;
        }
        return res;
    }
}
