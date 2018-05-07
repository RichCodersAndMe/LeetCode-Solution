package _121.kotlin

/**
 * @author relish
 * @since 2018/05/07
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        var ret = 0
        var min = prices[0]
        for (i in 1 until prices.size) {
            min = Math.min(min, prices[i])
            ret = Math.max(prices[i] - min, ret)
        }
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}