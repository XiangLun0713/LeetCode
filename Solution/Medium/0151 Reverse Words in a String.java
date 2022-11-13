class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for (int i = n - 1; i >= 0; i--) {
            if (words[i].isEmpty()) continue;
            sb.append(words[i]).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
