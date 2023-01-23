class Solution {
    public int findJudge(int n, int[][] trust) {
        Person[] ppl = new Person[n + 1];
        for (int i = 1; i <= n; i++) {
            ppl[i] = new Person();
        }
        for (int[] curr : trust) {
            ppl[curr[0]].trust = curr[1];
            ppl[curr[1]].trustedBy.add(curr[0]);
        }
        for (int i = 1; i <= n; i++) {
            Person curr = ppl[i];
            if (curr.trust == -1 && curr.trustedBy.size() == n - 1) return i;
        }
        return -1;
    }
}

class Person {
    int trust;
    List<Integer> trustedBy;
    
    public Person() {
        trust = -1;
        trustedBy = new ArrayList<>();
    }
}
