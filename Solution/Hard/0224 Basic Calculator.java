class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (c == ')') {
                sum = stack.pop() * sum;
                sum += stack.pop();
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                while (++i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = (num * 10) + (s.charAt(i) - '0');
                }
                sum += num * sign;
                i--;
            }
        }
        return sum;
    }
}
