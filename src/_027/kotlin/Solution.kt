package _027.kotlin

/**
 * @author relish
 * @since 2018/04/13
 */
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        for (index in nums.indices) {
            val t = nums[index]
            if (t != `val`) {
                nums[count++] = t
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf(3, 2, 3, 1, 2, 3, 2)
    println(Solution().removeElement(arr, 3))
}