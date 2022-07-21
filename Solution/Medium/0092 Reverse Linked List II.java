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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // add dummy head at the front
        ListNode temp = new ListNode(0, head);
        ListNode leftPrev = temp, curr = head, prev = null;
        
        // move curr pointer to the starting left node that needs operation
        for (int i = 0; i < left - 1; i++) {
            leftPrev = curr;
            curr = curr.next;
        }
        
        // reverse the target segment of the linked list
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // rearrange the links 
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        
        return temp.next;
    }
}
