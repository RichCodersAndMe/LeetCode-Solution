package _003.kotlin

import java.util.HashSet
import java.util.HashMap





/**
 * @author relish
 * @since 2018/10/20
 */
class Solution {
    fun lengthOfLongestSubstring1(s: String): Int {
        val n = s.length
        val set = HashSet<Char>()
        var ans = 0
        var i = 0
        var j = 0
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s[j])) {
                set.add(s[j++])
                ans = Math.max(ans, j - i)
            } else {
                set.remove(s[i++])
            }
        }
        return ans
    }


    fun lengthOfLongestSubstring2(s: String): Int {
        val n = s.length
        var ans = 0
        val map = HashMap<Char, Int>() // current index of character
        // try to extend the range [i, j]
        var j = 0
        var i = 0
        while (j < n) {
            if (map.containsKey(s[j])) {
                i = Math.max(map.get(s[j])!!, i)
            }
            ans = Math.max(ans, j - i + 1)
            map[s[j]] = j + 1
            j++
        }
        return ans
    }

    fun lengthOfLongestSubstring3(s: String): Int {
        val n = s.length
        var ans = 0
        val index = IntArray(128) // current index of character
        // try to extend the range [i, j]
        var j = 0
        var i = 0
        while (j < n) {
            i = Math.max(index[s[j].toInt()], i)
            ans = Math.max(ans, j - i + 1)
            index[s[j].toInt()] = j + 1
            j++
        }
        return ans
    }
}

fun main(args: Array<String>) {
    val str = "abcabcdsajdhjaskld"
    println(Solution().lengthOfLongestSubstring3(str))
}