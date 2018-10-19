package _504.kotlin

import java.util.*

/**
 * @author relish
 * @since 2018/10/19
 */
class Solution {
    fun convertToBase7(num: Int): String {
        if (num == 0) return "0"
        val isPositive = num >= 0
        var n = Math.abs(num)
        val sb = StringBuilder()
        while (n > 0) {
            sb.append(n % 7)
            n /= 7
        }
        sb.append(if (isPositive) "" else "-")
        return sb.reverse().toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextInt()
    println(_504.kotlin.Solution().convertToBase7(input))
}