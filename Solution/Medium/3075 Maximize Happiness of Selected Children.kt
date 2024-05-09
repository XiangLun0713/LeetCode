class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        var result = 0
        return happiness.map { it.toLong() }.sortedDescending().take(k).sumOf { value ->
            max(0L, value - result++)
        }
    }
}
