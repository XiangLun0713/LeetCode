class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = count(s);
        }
        return s;
    }

    private String count(String s) {
        char[] arr = s.toCharArray();
        int count = 1;
        char prev = arr[0];
        String result = "";
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != prev) {
                result += (String.valueOf(count) + prev);
                prev = arr[i];
                count = 1;
            } else {
                count++;
            }
        }
        result += (String.valueOf(count) + prev);
        return result;
    }
}
