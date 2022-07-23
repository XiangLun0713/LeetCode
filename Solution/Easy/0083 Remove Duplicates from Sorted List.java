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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-101, head);
        ListNode pointer = head;
        ListNode prev = temp;
        
        while (pointer != null) {
            if (pointer.val != prev.val) {
                prev.next = pointer;
                prev = pointer;
            }
            pointer = pointer.next;
        }
        
        prev.next = null;
        
        return temp.next;
    }
}
