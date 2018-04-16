package _028.kotlin

/**
 * @author relish
 * @since 2018/04/15
 */
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        
        if (haystack.isEmpty()) {
            return if (needle.isEmpty()) haystack.length else -1
        }
        if (needle.isEmpty()) {
            return 0
        }

        val first = needle[0]
        val max = 0 + (haystack.length - needle.length)

        var i = 0 + 0
        while (i <= max) {
            /* Look for first character. */
            if (haystack[i] != first) {
                while (++i <= max && haystack[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                var j = i + 1
                val end = j + needle.length - 1
                var k = 0 + 1
                while (j < end && haystack[j] == needle[k]) {
                    j++
                    k++
                }

                if (j == end) {
                    /* Found whole string. */
                    return i - 0
                }
            }
            i++
        }
        return -1
    }
}

fun main(args: Array<String>) {
    println(Solution().strStr("hello",""))
}