package _004.kotlin

/**
 * @author relish
 * @since 2018/10/20
 */
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val len = nums1.size + nums2.size
        return if (len % 2 == 0) {
            (fix(nums1, 0, nums2, 0, len / 2) + fix(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0
        } else {
            fix(nums1, 0, nums2, 0, len / 2 + 1).toDouble()
        }
    }

    fun fix(nums1: IntArray, n: Int, nums2: IntArray, m: Int, k: Int): Int {
        if (n >= nums1.size) return nums2[m + k - 1]
        if (m >= nums2.size) return nums1[n + k - 1]
        if (k == 1) return Math.min(nums1[n], nums2[m])

        val i1 = n + k / 2 - 1
        val i2 = m + k / 2 - 1
        val v1 = if (i1 < nums1.size) nums1[i1] else Int.MAX_VALUE
        val v2 = if (i2 < nums2.size) nums2[i2] else Int.MAX_VALUE
        return if (v1 < v2) {
            fix(nums1, n + k / 2, nums2, m, k - k / 2)
        } else {
            fix(nums1, n, nums2, m + k / 2, k - k / 2)
        }
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.findMedianSortedArrays(intArrayOf(2), intArrayOf(0)))
    println(solution.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    println(solution.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(-1, 3)))
}