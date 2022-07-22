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
    public ListNode partition(ListNode head, int x) {  
        ListNode high = new ListNode(0), low = new ListNode(0);
        ListNode pointer = head, highPointer = high, lowPointer = low;
        
        while (pointer != null) {
            if (pointer.val >= x) {
                highPointer.next = pointer;
                highPointer = highPointer.next;
            } else {
                lowPointer.next = pointer;
                lowPointer = lowPointer.next;
            }
            pointer = pointer.next;
        }
        
        // rearrange the linked list [low -> high] & truncate list node after highPointer
        lowPointer.next = high.next;
        highPointer.next = null;
        
        return low.next;
    }
}
