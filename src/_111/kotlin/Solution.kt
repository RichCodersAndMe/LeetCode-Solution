package _111.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/04/30
 */
class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        if (root.left == null) return minDepth(root.right) + 1
        if (root.right == null) return minDepth(root.left) + 1
        return 1 + Math.min(minDepth(root.left), minDepth(root.right))
    }
}

fun main(args: Array<String>) {
    println(Solution().minDepth(TreeNode.createTestData("[1,2]")))
}