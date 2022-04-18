class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String res : tokens) {
            if (res.equals("+") || res.equals("-") || res.equals("*") || res.equals("/")) {
                deque.push(compute(deque.pop(), deque.pop(), res));
            } else {
                deque.push(Integer.parseInt(res));
            }
        }
        return deque.pop();
    }
    private int compute(int operand1, int operand2, String operator) {
        switch(operator) {
            case "+" -> {
                return operand2 + operand1;
            }
            case "-" -> {
                return operand2 - operand1;
            }
            case "*" -> {
                return operand2 * operand1;
            }
            case "/" -> {
                return operand2 / operand1;
            }
            default -> {
                return 0;
            }
        }
    }
}
