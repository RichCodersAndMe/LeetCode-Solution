package _771.kotlin


// remove the line of `package xxx.xxx.xxx.xxx;` when you commit it

/**
 * @author relish
 * @since 2018/04/03
 */
class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0
        for (c in S.toCharArray()) {
            if (J.contains(c)) {
                count++
            }
        }
        return count
    }
}
fun main(args: Array<String>) {
    println(Solution().numJewelsInStones("aA", "aAAbbbb"))
}