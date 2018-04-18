package _053.kotlin

/**
 * @author relish
 * @since 2018/04/17
 */
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val len = nums.size
        var max = nums[0]
        var dp = nums[0]
        for (i in 1 until len) {
            dp = Math.max(dp + nums[i], nums[i])
            max = Math.max(max, dp)
        }
        return max
    }
}

fun main(args: Array<String>) {
    println(Solution().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}