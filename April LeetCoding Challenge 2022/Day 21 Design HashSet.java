// Implements HashSet with bucket size of 100
// Using seperate chaining method to deal with collision

class MyHashSet {
    private final int BUCKET_SIZE = 100;
    private List<List<Integer>> bucket;

    public MyHashSet() {
        bucket = new ArrayList<>(BUCKET_SIZE);
        for (int i = 0; i < BUCKET_SIZE; i++) {
            bucket.add(null);
        }
    }

    public void add(int key) {
        int index = key % BUCKET_SIZE;
        List<Integer> list = bucket.get(index);
        if (list == null) {
            bucket.set(index, new ArrayList<>(List.of(key)));

        } else if (!list.contains(key)) {
            list.add(key);

        }
    }

    public void remove(int key) {
        int index = key % BUCKET_SIZE;
        List<Integer> list = bucket.get(index);
        if (list != null && list.contains(key))
            list.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = key % BUCKET_SIZE;
        List<Integer> list = bucket.get(index);
        return (list != null) && (list.contains(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
