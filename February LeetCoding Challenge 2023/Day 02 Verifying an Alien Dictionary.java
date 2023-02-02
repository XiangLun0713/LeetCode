class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], map) == 1) return false;
        }
        return true;
    }

    //** return -1 when word1 is smaller, 1 when word1 is bigger, 0 when word1 and word2 is same */
    private int compare(String word1, String word2, int[] map) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int i = 0;
        for (; i < Math.min(arr1.length, arr2.length); i++) {
            if (map[arr1[i] - 'a'] < map[arr2[i] - 'a']) return -1;
            else if (map[arr1[i] - 'a'] > map[arr2[i] - 'a']) return 1;
        }
        if (arr1.length > i) return 1;
        else if (arr2.length > i) return -1;
        return 0;
    }
}
