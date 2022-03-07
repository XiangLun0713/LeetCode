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
        if(list1 == null && list2 == null) return null;
        if(list1 == null ^ list2 == null) return (list1 == null)? list2 : list1;
        
        ListNode result = new ListNode(-1);
        ListNode resultPointer = result;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val > pointer2.val){
                resultPointer.next = new ListNode(pointer2.val);
                resultPointer = resultPointer.next;
                pointer2 = pointer2.next;
            } else if (pointer2.val <= pointer2.val) {
                resultPointer.next = new ListNode(pointer1.val);
                resultPointer = resultPointer.next;
                pointer1 = pointer1.next;
            }
        }
        
        if (pointer1 != null){
           resultPointer.next = pointer1;  
        } else if (pointer2 != null) {
            resultPointer.next = pointer2;
        }
            
        return result.next;
    }
}
