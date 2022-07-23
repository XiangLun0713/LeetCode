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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = new ListNode(-1, list1);
        ListNode pointer = temp, start = null, end = null;
        
        // traverse list1 store the nodes right before a (start), and right after b (end)
        for (int i = -1; i <= b; i++) {
            if (i == a - 1) start = pointer;
            pointer = pointer.next;
        }
        end = pointer;
        
        // traverse list2 to the last node
        pointer = list2;        
        while(pointer.next != null) {
            pointer = pointer.next;
        }

        // link the start node with the head of list2
        start.next = list2;
        // link the tail of list2 with the end node
        pointer.next = end;
        
        return temp.next;
    }
}
