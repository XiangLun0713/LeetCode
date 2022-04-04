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

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        for (int i = 0; i < k - 1; i++) {
            fastPointer = fastPointer.next;
        }
        ListNode firstNode = fastPointer;
        
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        ListNode secondNode = slowPointer;
        
        int temp = secondNode.val;;
        secondNode.val = firstNode.val;
        firstNode.val = temp;
        
        return head;
    }
}
