package _067.kotlin

/**
 * @author relish
 * @since 2018/04/20
 */
class Solution {
    fun addBinary(a: String, b: String): String {
        val sb = StringBuilder()
        var flag = 0
        var i = a.length - 1
        var j = b.length - 1
        while (i >= 0 || j >= 0) {
            val ta = if (i < 0) 0 else a[i] - '0'
            val tb = if (j < 0) 0 else b[j] - '0'
            val t = ta + tb + flag
            flag = if (t > 1) 1 else 0
            sb.append(if (t > 1) t - 2 else t)
            i--
            j--
        }
        if (flag == 1) {
            sb.append('1')
        }
        return sb.reverse().toString()
    }
}

fun main(args: Array<String>) {
    println(Solution().addBinary("1111", "1111"))
}