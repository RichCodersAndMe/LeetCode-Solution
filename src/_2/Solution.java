package _2;
// remove the line of `package xxx.xxx.xxx.xxx;` when you commit it

/**
 * @author relish
 * @since 2018/04/02
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}