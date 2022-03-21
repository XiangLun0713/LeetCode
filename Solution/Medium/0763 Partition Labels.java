class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[26];
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'a'] = i;
        }
        int index = 0;
        while (!s.isEmpty()) {
            char c = s.charAt(0);
            int lastIndex = arr[c - 'a'] - index;
            for (int i = 0; i < lastIndex + 1; i++) {
                if (set.add(s.charAt(i))) {
                    lastIndex = Math.max(lastIndex, arr[s.charAt(i) - 'a'] - index);
                }
            }
            result.add(lastIndex + 1);
            index += lastIndex + 1;
            s = s.substring(lastIndex + 1);
            set.clear();
        }
        return result;
    }
}
