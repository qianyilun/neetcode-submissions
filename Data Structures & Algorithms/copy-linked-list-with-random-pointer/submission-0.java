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
        Map<Node, Node> copy = new HashMap<>();

        Node dummy = head;
        while (dummy != null) {
            copy.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }

        Node newHead = copy.get(head);
        dummy = head;

        while (dummy != null) {
            Node next = copy.get(dummy.next);
            Node random = copy.get(dummy.random);
            Node curr = copy.get(dummy);

            curr.next = next;
            curr.random = random;
            
            dummy = dummy.next;
        }
        
        return newHead;
    }
}
