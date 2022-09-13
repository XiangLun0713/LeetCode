class Solution {
    public boolean validUtf8(int[] data) {
        int[] index = new int[1];
        while (index[0] < data.length) {
            if (!valid(data, index)) return false;
        }
        return true;
    }
    
    private boolean valid(int[] data, int[] index) {
        String bin = intToBin(data[index[0]]);
        if (bin.indexOf('0') == 0) {
            index[0]++;
        } else if (bin.indexOf("110") == 0) {
            index[0]++;
            for (int i = 0; i < 1; i++) {
                if (index[0] >= data.length) return false;
                bin = intToBin(data[index[0]]);
                if (bin.indexOf("10") != 0) return false;
                index[0]++;
            }
        } else if (bin.indexOf("1110") == 0) {
            index[0]++;
            for (int i = 0; i < 2; i++) {
                if (index[0] >= data.length) return false;
                bin = intToBin(data[index[0]]);
                if (bin.indexOf("10") != 0) return false;
                index[0]++;
            }
        } else if (bin.indexOf("11110") == 0) {
            index[0]++;
            for (int i = 0; i < 3; i++) {
                if (index[0] >= data.length) return false;
                bin = intToBin(data[index[0]]);
                if (bin.indexOf("10") != 0) return false;
                index[0]++;
            }
        } else {
            return false;
        }
        return true;
    }
    
    private static String intToBin(int num) {
        String bin = Integer.toBinaryString(num);
        bin = "00000000".substring(0, 8 - bin.length()) + bin;
        return bin;
    }
}
