package _104.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/04/26
 *
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null) return 1 + maxDepth(root.right)
        if (root.right == null) return 1 + maxDepth(root.left)
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right))
    }
}

fun main(args: Array<String>) {
    println(Solution().maxDepth(TreeNode.createTestData("[3,9,20,null,null,15,7]")))
}