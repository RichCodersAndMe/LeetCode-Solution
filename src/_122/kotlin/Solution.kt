package _122.kotlin


/**
 * @author relish
 * @since 2018/05/08
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var sum = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1]
        }
        return sum
    }
}

fun main(args: Array<String>) {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Solution().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}