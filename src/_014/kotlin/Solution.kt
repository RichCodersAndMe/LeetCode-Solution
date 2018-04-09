package _014.kotlin

/**
 * @author relish
 * @since 2018/04/09
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var ret = ""
        for (i in 0 until strs[0].length) {
            val ch = strs[0][i]
            for (str in strs) {
                if (str.length <= i) return ret
                if (ch != str[i]) return ret
            }
            ret += ch
        }
        return ret
    }
}

fun main(args: Array<String>) {
    val strs = Array(5, { "" })
    strs[0] = "abcdefg"
    strs[1] = "abcdfefg"
    strs[2] = "abcdgefg"
    strs[3] = "abcddefg"
    strs[4] = "abce"

    println(Solution().longestCommonPrefix(strs))
}