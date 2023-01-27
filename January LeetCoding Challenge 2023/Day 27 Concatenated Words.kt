class Solution {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val wordSet = mutableSetOf<String>()
        for (word in words) wordSet.add(word)
        val result = mutableListOf<String>()

        fun goodWord(givenWord : String): Boolean {
            for (i in givenWord.indices) {
                val prefix = givenWord.substring(0, i)
                val suffix = givenWord.substring(i)
                if (wordSet.contains(prefix) && (wordSet.contains(suffix) || goodWord(suffix))) return true
            }
            return false
        }
        
        for (word in words) {
            if (goodWord(word)) result.add(word)
        }
        
        return result
    }
}
