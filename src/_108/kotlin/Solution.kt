package _108.kotlin

import structure.TreeNode

/**
 * @author relish
 * @since 2018/04/28
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return balance(nums, 0, nums.size - 1)
    }

    private fun balance(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val midIndex = (start + end) / 2
        val left = balance(nums, start, midIndex - 1)
        val right = balance(nums, midIndex + 1, end)
        val node = TreeNode(nums[midIndex])
        node.left = left
        node.right = right
        return node
    }
}

fun main(args: Array<String>) {
    var node = Solution().sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    TreeNode.print(node)

}