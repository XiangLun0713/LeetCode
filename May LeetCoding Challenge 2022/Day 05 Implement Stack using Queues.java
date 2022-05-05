class MyStack {
    private Queue<Integer> q1, q2;
    private int top;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
        top = x;
    }

    public int pop() {
        if (q1.isEmpty()) {
            int n = q2.size();
            for (int i = 0; i < n - 1; i++) {
                top = q2.poll();
                q1.offer(top);
            }
            return q2.poll();
        } else {
            int n = q1.size();
            for (int i = 0; i < n - 1; i++) {
                top = q1.poll();
                q2.offer(top);
            }
            return q1.poll();
        }
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
