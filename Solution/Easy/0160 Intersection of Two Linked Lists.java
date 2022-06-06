/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != null && pointerB != null) {
            while (pointerA != null) {
                if (!visited.add(pointerA)) {
                    return pointerA;   
                }
                pointerA = pointerA.next;
            }
            while (pointerB != null) {
                if (!visited.add(pointerB)) {
                    return pointerB;
                }
                pointerB = pointerB.next;
            }
        }
        return null;
    }
}
