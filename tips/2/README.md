## Description

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example**

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

## 思路

**链表**。


### kotlin
```kotlin
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
```
###  Java

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        ListNode prev = null;

        int co = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int val = val1 + val2 + co;
            if (val >= 10) {
                val %= 10;
                co = 1;
            } else {
                co = 0;
            }
            if (firstNode == null) {
                firstNode = new ListNode(val);
                prev = firstNode;
            } else {
                ListNode newNode = new ListNode(val);
                prev.next = newNode;
                prev = newNode;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (co == 1) {
            prev.next = new ListNode(1);
        }
        return firstNode;
    }
}
```
