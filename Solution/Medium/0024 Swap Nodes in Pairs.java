/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode result = new ListNode();
        ListNode headPointer = head;
        ListNode resultPointer = result;
        while (headPointer != null) {
            if (headPointer.next != null) {
                resultPointer.val = headPointer.next.val;
            } else {
                resultPointer.val = headPointer.val;
                break;
            }
            resultPointer.next = new ListNode(headPointer.val);
            headPointer = headPointer.next.next;
            if (headPointer != null) {
                resultPointer.next.next = new ListNode();
                resultPointer = resultPointer.next.next;
            }
        }
        return result;
    }
}
