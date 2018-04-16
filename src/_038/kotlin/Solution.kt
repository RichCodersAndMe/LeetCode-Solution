package _038.kotlin

/**
 * @author relish
 * @since 2018/04/16
 */
class Solution {
    fun countAndSay(n: Int): String {
        var say = "1"
        for (count in 1 until n) {
            say = say(say)
        }
        return say
    }

    private fun say(say: String): String {
        val newSay = StringBuilder()
        var prev = say[0]
        var tCount = 0
        for (i in say.indices) {
            if (say[i] == prev) {
                tCount++
                continue
            }
            newSay.append(tCount).append(prev)
            prev = say[i]
            tCount = 1
        }
        newSay.append(tCount).append(prev)
        return newSay.toString()
    }
}

fun main(args: Array<String>) {
    for (i in 1 until 10) {
        println(Solution().countAndSay(i))
    }
}