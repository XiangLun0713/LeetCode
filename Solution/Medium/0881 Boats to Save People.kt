class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var res = 0
        var start = 0
        var end = people.size - 1
        while (start <= end) {
            if (people[end] + people[start] > limit) {
                end--
            } else {
                end--
                start++
            }
            res++
        }
        return res
    }
}
