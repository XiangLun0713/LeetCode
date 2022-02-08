class Solution {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            int lastTwoDigit = num % 100;
            num = (num - lastTwoDigit) / 10;
            int sum = (lastTwoDigit / 10) + (lastTwoDigit % 10);
            num += sum;
        }
        return num;
    }
}
