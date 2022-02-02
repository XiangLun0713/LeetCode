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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer1 = head, pointer2 = head;
        for(int i = 0; i < n; i++) {
            if(pointer2.next == null) {
                if(pointer1 == pointer2) {
                    return null;
                } else {
                    return pointer1.next;
                }
            } else {
                pointer2 = pointer2.next;
            }
        }
        while(pointer2 != null && pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer1.next = pointer1.next.next;
        return head;
    }
}
