class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val sortedScore = score.sortedDescending()
        return score.map { num ->
            when(val place = sortedScore.indexOf(num) + 1) {
                1 -> "Gold Medal"
                2 -> "Silver Medal"
                3 -> "Bronze Medal"
                else -> place.toString()
            }
        }.toTypedArray()
    }
}
