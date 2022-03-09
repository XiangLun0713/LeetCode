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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        ListNode pointer = head;

        int skipVal = -1000;
        while (pointer != null) {
            if (pointer.val != skipVal) {
                if (hashMap.containsKey(pointer.val)) {
                    hashMap.remove(pointer.val);
                    skipVal = pointer.val;
                } else {
                    hashMap.put(pointer.val, pointer);
                }
            }
            pointer = pointer.next;
        }

        TreeSet<Integer> set = new TreeSet<>(hashMap.keySet());
        ListNode result = new ListNode(-1);
        pointer = result;
        for (int i : set) {
            pointer.next = hashMap.get(i);
            pointer = pointer.next;
        }
        pointer.next = null;

        return result.next;
    }
}
