package _125.kotlin

/**
 * @author relish
 * @since 2018/11/09
 */
class Solution {
    fun isPalindrome(s: String): Boolean {
        if (s == " ") return true
        val len = s.length
        var i = 0
        var j = len - 1
        while (i <= j) {
            try {
                while (!(s[i] in 'a'..'z' || s[i] in 'A'..'Z' || s[i] in '0'..'9')) i++
                while (!(s[j] in 'a'..'z' || s[j] in 'A'..'Z' || s[j] in '0'..'9')) j--
            } catch (e: Exception) {
                return true
            }
            try {
                if (!s[i++].equals(s[j--], true)) return false
            } catch (e: Exception) {
                return false
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    println(Solution().isPalindrome("A man, a plan, a canal: Panama"))
    println(Solution().isPalindrome("race a car"))
    println(Solution().isPalindrome(" "))
    println(Solution().isPalindrome("."))
    println(Solution().isPalindrome("0P"))
    println(Solution().isPalindrome("ab2a"))
}