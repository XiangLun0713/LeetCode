class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '*';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            chars[index] = '*';
        }
        String[] temp = String.valueOf(chars).split("\\*");
        StringBuilder result = new StringBuilder();
        for (String res : temp) {
            result.append(res);
        }
        return result.toString();  
    }
}
