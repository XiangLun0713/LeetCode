class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> hashMap;
    
    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hashMap.putIfAbsent(key, new TreeMap<>());
        hashMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = hashMap.get(key);
        if (treeMap == null) return "";
        Integer targetKey = treeMap.floorKey(timestamp);
        return (targetKey == null) ? "" : treeMap.get(targetKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
