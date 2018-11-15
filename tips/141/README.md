[Linked List Cycle][title]

## Description
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?


**Tags:** 
Linked List、Two Pointers


## 思路

java(0ms/100.00%): 
简单举个例子, 两个人在田径场上绕圈跑步, A的速度为1, B的速度为2, 总有某个时刻, B会追上A。(B和A在同一个位置)
```java
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        if (fast == null) return false;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
            if (fast == null) break;
        }
        return false;
    }
}
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/xxxx
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution