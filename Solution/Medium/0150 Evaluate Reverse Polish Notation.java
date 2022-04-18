class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String res : tokens) {
            if (res.equals("+")) {
                deque.push(deque.pop() + deque.pop());
            } else if(res.equals("*")) {
                deque.push(deque.pop() * deque.pop());
            } else if(res.equals("-")) {
                int temp = deque.pop();
                deque.push(deque.pop() - temp);
            } else if(res.equals("/")) {
                int temp = deque.pop();
                deque.push(deque.pop() / temp);
            } else {
                deque.push(Integer.parseInt(res));
            }
        }
        return deque.pop();
    }
}
