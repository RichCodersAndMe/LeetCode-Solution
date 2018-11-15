package _141;

import structure.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 *
 * @author relish
 * @since 2018/11/15
 */
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

    public static void main(String[] args) {
        System.out.println(new Solution().hasCycle(ListNode.createTestData("[1,2]")));
    }
}