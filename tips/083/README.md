# [Remove Duplicates from Sorted List][title]

## Description

Given a sorted linked list, delete all duplicates such that each element appear only *once*.

For example,

Given `1->1->2`, return `1->2`.

Given `1->1->2->3->3`, return `1->2->3`.

**Tags:** Linked List


## 思路

题意是删除链表中重复的元素，很简单，我们只需要遍历一遍链表，遇到链表中相邻元素相同时，把当前指针指向下下个元素即可。

Java:
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
```

kotlin(224ms/100.00%)
```kotlin
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
```

javascript
```javascript
var deleteDuplicates = function(head) {
    if(head === null || head.val === null || head.next === null) {
        return head
    }
    var current = head
    var currentVal = head.val
    while(true) {
        if(current.next === null) {
            break;
        }
        if(current.next.val === currentVal) {
            current.next = current.next.next
        } else {
            currentVal = current.next.val
            current = current.next
        }
    }
    return head
};
```
## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-list
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution
