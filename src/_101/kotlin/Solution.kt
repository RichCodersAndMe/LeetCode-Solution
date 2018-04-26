package _101.kotlin

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

    private fun symmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        return left.`val` == right.`val` && symmetric(left.right, right.left) && symmetric(left.left, right.right)
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        if (root.left == null && root.right == null) return true
        if (root.left == null || root.right == null) return false
        return symmetric(root.left, root.right)
    }
}

fun main(args: Array<String>) {
    println(Solution().isSymmetric(TreeNode.createTestData("[1,2,2,null,3,null,3]")))
}