package _002;

import structure.ListNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/11
 *     desc  :
 * </pre>
 */
public class Solution {
    
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode firstNode = null;
//        ListNode prev = null;
//
//        int co = 0;
//        while (l1 != null || l2 != null) {
//            int val1 = l1 == null ? 0 : l1.val;
//            int val2 = l2 == null ? 0 : l2.val;
//
//            int val = val1 + val2 + co;
//            if (val >= 10) {
//                val %= 10;
//                co = 1;
//            } else {
//                co = 0;
//            }
//            if (firstNode == null) {
//                firstNode = new ListNode(val);
//                prev = firstNode;
//            } else {
//                ListNode newNode = new ListNode(val);
//                prev.next = newNode;
//                prev = newNode;
//            }
//
//            l1 = l1 == null ? null : l1.next;
//            l2 = l2 == null ? null : l2.next;
//        }
//        if (co == 1) {
//            prev.next = new ListNode(1);
//        }
//        return firstNode;
//    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode n1 = l1, n2 = l2, t = node;
        int sum = 0;
        while (n1 != null || n2 != null) {
            sum /= 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            t.next = new ListNode(sum % 10);
            t = t.next;
        }
        if (sum / 10 != 0) t.next = new ListNode(1);
        return node.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.addTwoNumbers(
                ListNode.createTestData("[2,4,3]"),
                ListNode.createTestData("[5,6,4]")
        ));
    }
}
