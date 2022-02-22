class Solution {
    public int titleToNumber(String columnTitle) {
        int count = 0, sum = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            sum += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, count);
            count++;
        }
        return sum;
    }
}
