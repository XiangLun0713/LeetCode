/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNodes(head: ListNode?): ListNode? {
        val stack = ArrayDeque<ListNode>()
        var temp = head;
        while (temp != null) {
            stack.addLast(temp)
            temp = temp.next
        }
        var res = stack.removeLast()
        while (!stack.isEmpty()) {
            val curr = stack.removeLast()
            if (res.`val` <= curr.`val`) {
                curr.next = res;
                res = curr;
            }
        }
        return res;
    }
}
