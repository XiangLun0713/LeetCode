class UndergroundSystem {
    // id -> "startStation,startTime"
    private HashMap<Integer, String> idMap;
    // "startStation,endStation" -> time
    private HashMap<String, List<Integer>> timeMap;

    public UndergroundSystem() {
        idMap = new HashMap<>();
        timeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idMap.put(id, stationName.concat(",").concat(String.valueOf(t)));
    }

    public void checkOut(int id, String stationName, int t) {
        String info = idMap.get(id);
        String[] arr = info.split(",");
        String startStation = arr[0];
        int startTime = Integer.parseInt(arr[1]);
        idMap.remove(id);

        String key = startStation.concat(",").concat(stationName);
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>(List.of(t - startTime)));
        } else {
            timeMap.get(key).add(t - startTime);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation.concat(",").concat(endStation);
        List<Integer> time = timeMap.get(key);
        int count = 0, sum = 0;
        for (int res : time) {
            sum += res;
            count++;
        }
        return (sum * 1.0) / count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
