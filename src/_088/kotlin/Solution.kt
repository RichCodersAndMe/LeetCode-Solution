package _088.kotlin

import java.util.*

/**
 * @author relish
 * @since 2018/04/24
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index = n + m - 1
        var i = m - 1
        var j = n - 1

        while ((i >= 0 || j >= 0) && index >= 0) {
            if (j < 0 && i in 0..(m - 1)) {
                nums1[index--] = nums1[i--]
                continue
            }
            if (i < 0 && j in 0..(n - 1)) {
                nums1[index--] = nums2[j--]
                continue
            }
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--]
            } else {
                nums1[index--] = nums2[j--]
            }
        }
    }
}

fun main(args: Array<String>) {
    val arr1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val arr2 = intArrayOf(2, 5, 6)
    Solution().merge(arr1, 3, arr2, 3)
    println(Arrays.toString(arr1))
}