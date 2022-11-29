class RandomizedSet {

    private HashMap<Integer, Integer> hashMap;
    private List<Integer> list;
    private Random random;
    
    public RandomizedSet() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (hashMap.containsKey(val)) return false;
        hashMap.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) return false;
        int index = hashMap.get(val);
        int n = list.size();
        int temp = list.get(n - 1);
        list.set(index, temp);
        list.set(n - 1, val);
        list.remove(n - 1);
        hashMap.put(temp, index);
        hashMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        int rand = random.nextInt(list.size());
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
