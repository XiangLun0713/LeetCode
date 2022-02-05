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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return divideAndConquer(lists);
    }

    private ListNode divideAndConquer(ListNode[] lists) {
        if(lists.length == 1) return lists[0];
        
        ListNode node1, node2;
        int mid = (lists.length - 1) / 2;
        node1 = divideAndConquer(Arrays.copyOfRange(lists, 0, mid + 1));
        node2 = divideAndConquer(Arrays.copyOfRange(lists, mid + 1, lists.length));
        return sortNode(node1, node2); 
    }

    private ListNode sortNode(ListNode node1, ListNode node2) {
        ArrayList<Integer> values = new ArrayList<>();
        if (node1 != null) {
            do {
                values.add(node1.val);
                node1 = node1.next;
            } while (node1 != null);
        }
        if (node2 != null) {
            do {
                values.add(node2.val);
                node2 = node2.next;
            } while (node2 != null);
        }
        if (values.size() > 0) {
            Collections.sort(values);
            ListNode result = new ListNode(values.get(values.size() - 1));
            for (int i = values.size() - 2; i >= 0; i--) {
                result = new ListNode(values.get(i), result);
            }
            return result;
        }
        return null;
    }
    
}
