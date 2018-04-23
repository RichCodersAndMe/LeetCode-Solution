# [Merge Two Sorted Lists][title]

## Description

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

**Tags:** Linked List


## 思路

题意是用一个新链表来合并两个已排序的链表，那我们只需要从头开始比较已排序的两个链表，新链表指针每次指向值小的节点，依次比较下去，最后，当其中一个链表到达了末尾，我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。
java:
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
```
kotlin:
```kotlin
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1
        val head: ListNode
        var p: ListNode
        var n1 = l1
        var n2 = l2
        if (n1.`val` > n2.`val`) {
            head = n2
            p = head
            n2 = n2.next
        } else {
            head = n1
            p = head
            n1 = n1.next
        }
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                p.next = n2
                break
            } else if (n2 == null) {
                p.next = n1
                break
            }
            if (n1.`val` > n2.`val`) {
                p.next = n2
                p = p.next
                n2 = n2.next
            } else {
                p.next = n1
                p = p.next
                n1 = n1.next
            }
        }
        return head
    }
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/merge-two-sorted-lists
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
