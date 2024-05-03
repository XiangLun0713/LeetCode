class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split(".").map { it.toInt() }.toMutableList()
        val v2 = version2.split(".").map { it.toInt() }.toMutableList()
        while (v1.size != v2.size) {
            if (v1.size < v2.size) v1.add(0)
            else v2.add(0)
        }
        v1.zip(v2).forEach { (val1, val2) ->
            if (val1 > val2) return 1
            else if (val1 < val2) return -1
        }
        return 0
    }
}
