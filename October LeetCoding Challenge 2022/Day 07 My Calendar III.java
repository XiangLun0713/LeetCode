class MyCalendarThree {

    private TreeMap<Integer, Integer> timeline;
    
    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int onGoing = 0, k = 0;
        for (int value : timeline.values()) {
            onGoing += value;
            k = Math.max(k, onGoing);
        }
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
