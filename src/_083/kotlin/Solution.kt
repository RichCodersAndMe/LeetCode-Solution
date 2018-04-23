package _083.kotlin

import structure.ListNode

/**
 * @author relish
 * @since 2018/04/23
 */
/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head
        var cur = head
        while (cur!!.next != null) {
            if (cur.`val` == cur.next.`val`) {
                cur.next = cur.next.next
            } else {
                cur = cur.next
            }
        }
        return head
    }
}

fun main(args: Array<String>) {
    val n = ListNode(1)
    n.next = ListNode(1)
    n.next.next = ListNode(2)
    n.next.next.next = ListNode(3)
    n.next.next.next.next = ListNode(3)
    var listNode = Solution().deleteDuplicates(n)
    while (listNode != null) {
        println(listNode.`val`)
        listNode = listNode.next
    }
}