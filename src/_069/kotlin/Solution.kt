package _069.kotlin

/**
 * @author relish
 * @since 2018/04/21
 */
class Solution {
    fun mySqrt(x: Int): Int {
        var k = x.toLong()
        while (k * k > x)
            k = (k + x / k) / 2
        return k.toInt()
    }
}

fun main(args: Array<String>) {
    println(Solution().mySqrt(2147395599))
    println(Solution().mySqrt(8))
    println(Solution().mySqrt(120))
}