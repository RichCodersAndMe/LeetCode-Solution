package _066.kotlin

import java.util.*

/**
 * @author relish
 * @since 2018/04/19
 */
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var flag = 1
        val len = digits.size
        for (i in len - 1 downTo 0) {
            digits[i] += flag
            if (digits[i] >= 10) {
                digits[i] %= 10
                flag = 1
                continue
            }
            flag = 0
            break
        }
        if (flag == 1) {
            return IntArray(len+1,fun(index: Int):Int{
                if(index==0)return 1
                return digits[index-1]
            })
        }
        return digits
    }
}

fun main(args: Array<String>) {
    println(Arrays.toString(Solution().plusOne(intArrayOf(9, 9, 9, 9))))
}
//val ret = IntArray(len + 1)
//ret[0] = 1
//for (i in digits.indices) {
//    ret[i + 1] = digits[i]
//}
//return ret