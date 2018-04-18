package _058.kotlin

/**
 * @author relish
 * @since 2018/04/18
 */
class Solution {
    fun lengthOfLastWord(s: String): Int {
        var count = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] == ' ') {
                if (count == 0) continue
                return count
            } else {
                count++
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution().lengthOfLastWord("a "))
    println(Solution().lengthOfLastWord("Hello World"))
}