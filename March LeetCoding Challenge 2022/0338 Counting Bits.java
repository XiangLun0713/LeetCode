class Solution {
    public int[] countBits(int n) {
        switch (n) {
            case 0 -> {
                return new int[]{0};
            }
            case 1 -> {
                return new int[]{0, 1};
            }
            case 2 -> {
                return new int[]{0, 1, 1};
            }
            case 3 -> {
                return new int[]{0, 1, 1, 2};
            }
            default -> {
                int[] memoize = new int[n + 1];
                System.arraycopy(new int[]{0, 1, 1, 2}, 0, memoize, 0, 4);
                for (int i = 4; i < memoize.length; i++) {
                    if (i % 2 == 0) {
                        memoize[i] = memoize[i / 2];
                    } else {
                        memoize[i] = memoize[(i - 1) / 2] + 1;
                    }
                }

                return memoize;
            }
        }
    }
}
