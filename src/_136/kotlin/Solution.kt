package _136.kotlin

import java.util.*
import kotlin.collections.HashMap

/**
 * @author relish
 * @since 2018/11/14
 */
class Solution {
    fun singleNumber1(nums: IntArray): Int {
        val c = HashSet<Int>()
        val r = HashSet<Int>()
        for (num in nums) {
            if (r.contains(num)) continue
            if (c.contains(num)) {
                c.remove(num)
                r.add(num)
            } else {
                c.add(num)
            }
        }
        return c.single()
    }

    fun singleNumber(nums: IntArray): Int {
        var s = 0
        for (num in nums) {
            s = s.xor(num)
        }
        return s
    }
}

fun main(args: Array<String>) {
    println(Solution().singleNumber(intArrayOf(2, 2, 1)))
    println(Solution().singleNumber(intArrayOf(4, 1, 2, 1, 2)))
}