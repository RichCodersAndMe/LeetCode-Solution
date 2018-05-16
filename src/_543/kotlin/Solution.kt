package _543.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/05/10
 *
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null || root.left == null && root.right == null) return 0
        val height = depth(root.left) + depth(root.right)
        return maxOf(height, maxOf(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)))
    }

    fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxOf(depth(root.left), depth(root.right))
    }
}

fun main(args: Array<String>) {
//    val root = TreeNode.createTestData("[1,2]")
    val root = TreeNode.createTestData("[1,2,3,4,5]")
    TreeNode.print(root)
    println(Solution().diameterOfBinaryTree(root))
}