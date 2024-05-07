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
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode result = null;
        int carry = 0;
        while (!stack.isEmpty()) {
            ListNode curr = stack.pop();
            int target = curr.val * 2 + carry;
            if (target > 9) {
                // if two digit
                carry = 1;
            } else {
                carry = 0;
            }
            curr.val = target % 10;
            curr.next = result;
            result = curr;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = result;
            result = temp;
        }
        return result;
    }
}
