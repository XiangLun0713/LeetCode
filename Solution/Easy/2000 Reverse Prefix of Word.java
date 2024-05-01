class Solution {
    public String reversePrefix(String word, char ch) {
        char[] charArr = word.toCharArray();
        int index = word.indexOf(ch);
        if (index == -1) return word;
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        return sb.reverse().toString() + word.substring(index + 1);
    }
}
