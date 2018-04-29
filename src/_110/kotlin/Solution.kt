package _110.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/04/30
 * <p>
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 * var left: TreeNode? = null
 * var right: TreeNode? = null
 * }
 */
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        val left = depth(root.left)
        val right = depth(root.right)
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }

    private fun depth(node: TreeNode?): Int {
        return if (node == null) 0 else 1 + Math.max(depth(node.left), depth(node.right))
    }
}

fun main(args: Array<String>) {
    val node = TreeNode.createTestData("[3,9,20,null,null,15,7]")
//    TreeNode.print(node)
    println(Solution().isBalanced(node))
}