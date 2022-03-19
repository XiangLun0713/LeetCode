class FreqStack {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    HashMap<Integer, Integer> freq = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {

    }

    public void push(int val) {
        int valFreq = 0;
        if (freq.containsKey(val)) {
            valFreq = freq.get(val) + 1;
            freq.put(val, valFreq);
        } else {
            valFreq = 1;
            freq.put(val, 1);
        }

        if (hashMap.containsKey(valFreq)) {
            hashMap.get(valFreq).add(val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(val);
            hashMap.put(valFreq, list);
        }
        maxFreq = Math.max(maxFreq, valFreq);
    }

    public int pop() {
        List<Integer> list = hashMap.get(maxFreq);
        int popValue = list.get(list.size() - 1);
        if (list.size() == 1) {
            --maxFreq;
        }
        freq.put(popValue, freq.get(popValue) - 1);
        list.remove(list.size() - 1);
        return popValue;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
