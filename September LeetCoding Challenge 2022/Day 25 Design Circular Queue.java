class MyCircularQueue {
    
    private final int[] arr;
    private int front = 0;
    private int rear = -1;

    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
    }

    public boolean enQueue(int value) {
        int newRear = (rear + 1 == arr.length) ? 0 : rear + 1;
        if (arr[newRear] != -1) return false;
        rear = newRear;
        arr[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (arr[front] == -1) return false;
        arr[front] = -1;
        front = (front + 1 == arr.length) ? 0 : front + 1;
        return true;
    }

    public int Front() {
        return arr[front];
    }

    public int Rear() {
        if (rear == -1) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        for (int num : arr) {
            if (num != -1) return false;
        }
        return true;
    }

    public boolean isFull() {
        for (int num : arr) {
            if (num == -1) return false;
        }
        return true;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
