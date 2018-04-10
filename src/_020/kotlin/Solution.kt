package _020.kotlin

import java.util.*

/**
 * @author relish
 * @since 2018/04/10
 */
class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val map = mapOf(')' to '(', ']' to '[', '}' to '{')
        return s.all {
            if (it !in map) {
                stack.add(it)
            } else {
                !stack.isEmpty() && stack.pop() == map[it]
            }
        } && stack.isEmpty()
    }
}

fun main(args: Array<String>) {
    println(Solution().isValid("{(})"))
    println(Solution().isValid("{({})}"))
    println(Solution().isValid("{([])}"))
}