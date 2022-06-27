class Solution {
    public int minPartitions(String n) {
        char c = '0';
        for (char res : n.toCharArray()) {
            if (c == '9') return 9;
            if (res > c) c = res;
        }
        return c - '0';
    }
}
