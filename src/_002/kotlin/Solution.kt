package _002.kotlin

// remove the line of `package xxx.xxx.xxx.xxx;` when you commit it

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 *
 * @author relish
 * @since 2018/04/02
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var n1 = l1
        var n2 = l2
        var firstNode: ListNode? = null
        var prev: ListNode? = null

        var co = 0
        while (n1 != null || n2 != null) {
            val van1 = n1?.`val` ?: 0
            val van2 = n2?.`val` ?: 0

            var item = van1 + van2 + co
            if (item >= 10) {
                item %= 10
                co = 1
            } else {
                co = 0
            }
            if (firstNode == null) {
                firstNode = ListNode(item)
                prev = firstNode
            } else {
                val newNode = ListNode(item)
                prev!!.next = newNode
                prev = newNode
            }

            n1 = n1?.next
            n2 = n2?.next
        }
        if (co == 1) {
            prev!!.next = ListNode(1)
        }
        return firstNode
    }
}

fun main(args: Array<String>) {
    val l1 = ListNode(2)
    val l11 = ListNode(4)
    l1.next = l11
    l11.next = ListNode(3)

    val l2 = ListNode(5)
    val l22 = ListNode(6)
    l2.next = l22
    l22.next = ListNode(4)

    var listNode = Solution().addTwoNumbers(l1, l2)
    while (listNode != null) {
        print(listNode.`val`.toString() + " ")
        listNode = listNode.next
    }
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}