class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.size() == 0) {
                    return false;
                } else if (isSameType(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private static boolean isSameType(char c1, char c2) {
        if (c1 == '(') {
            return c2 == ')';
        } else if (c1 == '[') {
            return c2 == ']';
        } else if (c1 == '{') {
            return c2 == '}';
        } else {
            return false;
        }
    }
}
