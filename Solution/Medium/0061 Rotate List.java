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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode pointer = head;
        int n = 0;
        while (pointer != null){
            n++;
            pointer = pointer.next;
        }
        
        if( k > n) {
            k %= n;
        }
        
        ListNode result = new ListNode(0);
        ListNode resultPointer = result;
        pointer = head;
        for (int i = 0; i < n - k; i++) {
            pointer = pointer.next;
        }
        
        while (pointer != null) {
            resultPointer.next = new ListNode(pointer.val);
            resultPointer = resultPointer.next;
            pointer = pointer.next;
        }

        pointer = head;
        for (int i = 0; i < n - k; i++) {
            resultPointer.next = new ListNode(pointer.val);
            resultPointer = resultPointer.next;
            pointer = pointer.next;
        }
        
        return result.next;
    }
}
