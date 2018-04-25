package _100.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/04/25
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        return p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}

fun main(args: Array<String>) {
    val p = TreeNode(1)
    p.left = TreeNode(2)
    p.right = TreeNode(2)

    val q = TreeNode(1)
    q.left = TreeNode(2)
    q.right = TreeNode(2)

    println(Solution().isSameTree(p, q))
}