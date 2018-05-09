package _226.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/05/09
 *
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val tmp = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(tmp)
        return root
    }
}
fun main(args: Array<String>) {
    val tree = TreeNode.createTestData("[4,2,7,1,3,6,9]")
    TreeNode.print(tree)
    val invertTree = Solution().invertTree(tree)
    TreeNode.print(invertTree)
}