import java.math.BigInteger;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        BigInteger sum = arrayToBigInt(num).add(BigInteger.valueOf(k));
        return BigIntToList(sum);
    }

    private BigInteger arrayToBigInt(int[] num) {
        BigInteger result = new BigInteger("0");
        for (int i : num) {
            result = (result.multiply(BigInteger.valueOf(10))).add(BigInteger.valueOf(i));
        }
        return result;
    }
    private List<Integer> BigIntToList(BigInteger k) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (k.compareTo(BigInteger.ZERO) > 0) {
            BigInteger num = (k.mod(BigInteger.TEN));
            k = k.divide(BigInteger.TEN);
            deque.addFirst(num.intValue());
        }
        return new ArrayList<>(deque);
    }
}
