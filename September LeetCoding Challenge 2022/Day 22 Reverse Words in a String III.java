class Solution {
    public String reverseWords(String s) {
        String[] wordArr = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (String word : wordArr) {
            sb.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
