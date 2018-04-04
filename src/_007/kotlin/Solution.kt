package _007.kotlin

/**
 * @author relish
 * @since 2018/04/04
 */
class Solution {
    fun reverse(x: Int): Int {
        val symbol = if (x > 0) 1 else -1
        val absX = Math.abs(x)
        return try {
            Integer.parseInt(StringBuilder(String.format("%d", absX)).reverse().toString()) * symbol
        }catch(e: Exception) {
            0
        }
    }
}