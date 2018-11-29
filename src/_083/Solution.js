/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
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