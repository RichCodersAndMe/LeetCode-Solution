package _070.kotlin

/**
 * @author relish
 * @since 2018/04/22
 */
class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        var a = 1
        var b = 2
        var c: Int
        for (i in 2 until n) {
            c = b
            b += a
            a = c
        }
        return b
    }
}

fun main(args: Array<String>) {
    println(Solution().climbStairs(3))
}

