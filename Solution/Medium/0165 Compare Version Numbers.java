class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int len1 = str1.length;
        int len2 = str2.length;

        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (Integer.parseInt(str1[i]) < Integer.parseInt(str2[i])) {
                    return -1;
                } else if (Integer.parseInt(str1[i]) > Integer.parseInt(str2[i])) {
                    return 1;
                }
            }
            return 0;
        } else if (len1 < len2) {
            int i = 0;
            for (; i < len1; i++) {
                if (Integer.parseInt(str1[i]) < Integer.parseInt(str2[i])) {
                    return -1;
                } else if (Integer.parseInt(str1[i]) > Integer.parseInt(str2[i])) {
                    return 1;
                }
            }
            for (int j = i; j < len2; j++) {
                if (Integer.parseInt(str2[j]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            int i = 0;
            for (; i < len2; i++) {
                if (Integer.parseInt(str1[i]) < Integer.parseInt(str2[i])) {
                    return -1;
                } else if (Integer.parseInt(str1[i]) > Integer.parseInt(str2[i])) {
                    return 1;
                }
            }
            for (int j = i; j < len1; j++) {
                if (Integer.parseInt(str1[j]) > 0) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
