fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    var i = 0
    return happiness.sortedDescending().take(k).sumOf { value ->
        max(0L, value.toLong() - i++)
    }
}