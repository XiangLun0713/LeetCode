class Solution {
    public int numberOfBeams(String[] bank) {
        int count = 0;
        int prevDeviceCount = 0;
        for (String s : bank) {
            char[] arr = s.toCharArray();
            int deviceCount = 0;
            for (char c : arr) {
                if (c == '1') {
                    deviceCount++;
                }
            }
            if (deviceCount != 0) {
                count += prevDeviceCount * deviceCount;
                prevDeviceCount = deviceCount;
            }
        }
        return count;
    }
}
