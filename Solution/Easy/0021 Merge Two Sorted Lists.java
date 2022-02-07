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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1 == null && list2 == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        while(list1 != null){
            list.add(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        ListNode result = new ListNode(-1);
        ListNode node = result;
        while(!list.isEmpty()){
            node.next = new ListNode(list.remove(0));
            node = node.next;
        }
        return result.next;
    }
}
