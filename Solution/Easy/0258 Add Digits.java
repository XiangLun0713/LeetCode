class Solution {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            String sNum = Integer.toString(num);
            int sum = 0;
            for (int i = 0; i < sNum.length(); i++) {
                sum += Integer.parseInt(String.valueOf(sNum.charAt(i)));
            }
            num = sum;
        }
        return num;
    }
}
