package _035.kotlin

/**
 * @author relish
 * @since 2018/04/15
 */
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return left
    }
}

fun main(args: Array<String>) {
    println(Solution().searchInsert(intArrayOf(1,3,5,6), 5))
}