/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node pointer = head;
        while (pointer != null) {
            Node next = pointer.next;
            pointer.next = new Node(pointer.val);
            pointer.next.next = next;
            pointer = next;
        }

        pointer = head;
        while (pointer != null) {
            Node random = pointer.random;
            Node next = pointer.next;
            if (random != null) {
                next.random = random.next;
            } else {
                next.random = null;
            }
            pointer = pointer.next.next;
        }

        Node result = new Node(0);
        Node resultPointer = result;
        pointer = head;
        while (pointer != null) {
            resultPointer.next = pointer.next;
            pointer.next = pointer.next.next;
            resultPointer = resultPointer.next;
            pointer = pointer.next;
        }

        return result.next;
    }
}
