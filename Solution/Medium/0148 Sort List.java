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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode midNode = getMid(head);
        ListNode rightNode = midNode.next;
        midNode.next = null;

        ListNode sortedLeft = sortList(rightNode);
        ListNode sortedRight = sortList(head);

        return mergeNode(sortedLeft, sortedRight);
    }

    private ListNode mergeNode(ListNode leftNode, ListNode rightNode) {
        ListNode result = new ListNode(-1);
        ListNode leftPointer = leftNode;
        ListNode rightPointer = rightNode;
        ListNode resultPointer = result;

        while (leftPointer != null && rightPointer != null) {
            int left = leftPointer.val;
            int right = rightPointer.val;
            if (left < right) {
                resultPointer.next = new ListNode(left);
                leftPointer = leftPointer.next;
            } else {
                resultPointer.next = new ListNode(right);
                rightPointer = rightPointer.next;
            }
            resultPointer = resultPointer.next;
        }
        if (rightPointer != null) {
            resultPointer.next = rightPointer;
        } else if (leftPointer != null) {
            resultPointer.next = leftPointer;
        }
        return result.next;
    }

    private ListNode getMid(ListNode node) {
        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
