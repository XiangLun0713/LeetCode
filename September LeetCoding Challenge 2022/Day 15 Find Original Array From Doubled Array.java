class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        int[] freq = new int[100001];
        for (int num : changed) {
            freq[num]++;
        }

        Arrays.sort(changed);

        int index = 0;
        int[] result = new int[n / 2];
        for (int num : changed) {
            if (freq[num] == 0) continue;
            if (num * 2 < 100001 && freq[num * 2] > 0) {
                freq[num]--;
                freq[num * 2]--;
                result[index++] = num;
            } else {
                return new int[0];
            }
        }

        return result;
    }
}
