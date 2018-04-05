package _009.kotlin

/**
 * @author relish
 * @since 2018/04/05
 */
class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var x1 = x
        var sum = 0
        while (x1 > 0) {
            sum = sum * 10 + x1 % 10
            x1 /= 10
        }
        return x == sum
    }
}

fun main(args: Array<String>) {
    println(Solution().isPalindrome(0))
    println(Solution().isPalindrome(-2147447412))
}