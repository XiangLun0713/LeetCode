// Implements HashMap by using a bucket size of 100
// Using Separate Chaining to resolve collision

class MyHashMap {
    private final int BUCKET_SIZE = 100;
    private List<List<Integer[]>> bucket;

    public MyHashMap() {
        bucket = new ArrayList<>(BUCKET_SIZE);
        for (int i = 0; i < BUCKET_SIZE; i++) {
            bucket.add(null);
        }
    }

    public void put(int key, int value) {
        int index = key % BUCKET_SIZE;
        List<Integer[]> list = bucket.get(index);
        if (list == null) {
            List<Integer[]> temp = new ArrayList<>();
            Integer[] pair = new Integer[]{key, value};
            temp.add(pair);
            bucket.set(index, temp);
        } else {
            boolean found = false;
            for (Integer[] res : list) {
                if (res[0] == key) {
                    res[1] = value;
                    return;
                }
            }
            list.add(new Integer[]{key, value});
        }
    }

    public int get(int key) {
        int index = key % BUCKET_SIZE;
        List<Integer[]> list = bucket.get(index);
        if (list != null) {
            for (Integer[] res : list) {
                if (res[0] == key) {
                    return res[1];
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % BUCKET_SIZE;
        List<Integer[]> list = bucket.get(index);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] == key) {
                    list.remove(list.get(i));
                    break;
                }
            }
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
