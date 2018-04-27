package _107.kotlin

import structure.TreeNode
import java.util.*

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

    private fun turn(list: ArrayList<ArrayList<Int>>, node: TreeNode?, depth: Int) {
        if (node == null) return
        if (list.size <= depth) list.add(ArrayList())
        list[depth].add(node.`val`)
        turn(list, node.left, 1 + depth)
        turn(list, node.right, 1 + depth)
    }

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        turn(list, root, 0)
        list.reverse()
        return list
    }
}

fun main(args: Array<String>) {
    val list = Solution().levelOrderBottom(TreeNode.createTestData("[3,9,20,null,null,15,7]"))
    println(list)
}