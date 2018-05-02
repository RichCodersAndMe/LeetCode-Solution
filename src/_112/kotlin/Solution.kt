package _112.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/05/02
 *
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 * [1] 1 true
 * [] 0 false
 */
class Solution {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) return sum == root.`val`
        return hasPathSum(root.right, sum - root.`val`) || hasPathSum(root.left, sum - root.`val`)
    }
}

fun main(args: Array<String>) {
    println(Solution().hasPathSum(TreeNode.createTestData("[1]"), 1))
}