// Using a stack for each string input and compare the stacks 
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return populateStack(s).toString().equals(populateStack(t).toString());
    }
    
    private Stack<Character> populateStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack;
    }
}
