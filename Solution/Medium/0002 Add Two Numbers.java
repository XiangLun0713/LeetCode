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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        boolean hasCarry = false;
        while(l1 != null && l2 != null) {
            int currVal = 0;
            if(hasCarry) {
                currVal = l1.val + l2.val + 1;
            } else {
                currVal = l1.val + l2.val;
            }
            pointer.next = new ListNode(currVal % 10);
            if (currVal / 10 > 0) {
                hasCarry = true;
            } else {
                hasCarry = false;
            }
            pointer = pointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int currVal = 0;
            if(hasCarry) {
                currVal = l1.val + 1;
            } else {
                currVal = l1.val;
            }
            pointer.next = new ListNode(currVal % 10);
            if (currVal / 10 > 0) {
                hasCarry = true;
            } else {
                hasCarry = false;
            }
            pointer = pointer.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int currVal = 0;
            if(hasCarry) {
                currVal = l2.val + 1;
            } else {
                currVal = l2.val;
            }
            pointer.next = new ListNode(currVal % 10);
            if (currVal / 10 > 0) {
                hasCarry = true;
            } else {
                hasCarry = false;
            }
            pointer = pointer.next;
            l2 = l2.next;
        }
        if(hasCarry) pointer.next = new ListNode(1);
        return result.next;
    }
}
