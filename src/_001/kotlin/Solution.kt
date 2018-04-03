package _1.kotlin

import java.util.*

// remove the line of `package xxx.xxx.xxx.xxx;` when you commit it

/**
 * @author relish
 * @since 2018/04/01
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val arr: IntArray = intArrayOf(0, 0)
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i
                    arr[1] = j
                    return arr
                }
            }
        }
        return arr
    }
}

fun main(args: Array<String>) {
    println(Arrays.toString(Solution().twoSum(intArrayOf(3, 2, 4), 6)))
}
