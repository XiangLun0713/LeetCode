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
        String s1 = "", s2 = "";
        while (l1 != null) {
            s1 = l1.val + s1;
            l1 = l1.next;
        }
        while (l2 != null) {
            s2 = l2.val + s2;
            l2 = l2.next;
        }
        String ans = (new java.math.BigInteger(s1).add(new java.math.BigInteger(s2))).toString();
        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        for(int i = ans.length() - 1; i >= 0; i--) {
            pointer.next = new ListNode(Integer.parseInt(String.valueOf(ans.charAt(i))));
            pointer = pointer.next;
        }
        return result.next;
    }
}
