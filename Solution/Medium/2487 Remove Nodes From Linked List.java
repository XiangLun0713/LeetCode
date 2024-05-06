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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode res = stack.pop();
        while(!stack.isEmpty()) {
            ListNode curr = stack.pop();
            if (res.val > curr.val) {
                continue;
            }
            curr.next = res;
            res = curr;
        }
        return res;
    }
}
