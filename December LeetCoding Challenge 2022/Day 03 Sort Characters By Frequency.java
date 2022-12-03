class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (char c : hashMap.keySet()) {
            pq.offer(new Pair(c, hashMap.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            sb.append(String.valueOf(curr.c).repeat(Math.max(0, curr.freq)));
        }
        return sb.toString();
    }
}

class Pair {
    char c;
    int freq;
    
    public Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}
