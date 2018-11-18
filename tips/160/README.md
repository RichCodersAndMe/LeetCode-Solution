[Intersection of Two Linked Lists][title]

## Description
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
```

begin to intersect at node c1.

**Note:**  
 
 - If the two linked lists have no intersection at all, return null.
 - The linked lists must retain their original structure after the function returns.
 - You may assume there are no cycles anywhere in the entire linked structure.
 - Your code should preferably run in O(n) time and use only O(1) memory.

**Credits:**  

Special thanks to [@stellari](https://leetcode.com/discuss/user/stellari) for adding this problem and creating all test cases.

**Tags:**   
`Linked List`

## 思路 1
这道题的思路与141题思路类似。
A链结束就到B链的头, B链结束就到A链的头。
如果两者的相同节点在同一个位置, 则第一遍循环就能找到;
如果不在同一位置, 就如同跑道上速度不同的运动员的追赶问题；
如果两者同时到达尾节点, 则说明无相交节点。 

java(2ms/100.00%): 
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
        return null;
    ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
        a = a == null ? headB : a.next;
        b = b == null ? headA : b.next;
    }
    return a;
}
```

## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/intersection-of-two-linked-lists/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution