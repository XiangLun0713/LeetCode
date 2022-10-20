class Solution {
    public String intToRoman(int num) {
        String[] I = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] X = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] C = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] M = new String[] {"", "M", "MM", "MMM"};
        return M[num / 1000] + C[(num %= 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
