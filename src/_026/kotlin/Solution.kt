package _026.kotlin

/**
 * 268ms
 * 96.77%
 * @author relish
 * @since 2018/04/12
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 2) return nums.size
        var t: Int
        var j = 1
        var i = 1
        while (i < nums.size) {
            t = i
            while (i < nums.size && nums[i] == nums[t - 1]) {
                i++
            }
            if (i < nums.size) {
                nums[j] = nums[i]
                j++
                i++
            }
        }
        return j
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf(1, 1, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7)
    println(Solution().removeDuplicates(arr))
}