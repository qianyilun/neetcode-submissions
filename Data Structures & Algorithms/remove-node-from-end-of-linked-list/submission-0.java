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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);

        if (size - n == 0) {
            return head.next;
        }
        
        ListNode[] pair = getPositionNode(head, size - n);

        ListNode prev = pair[0];
        ListNode curr = pair[1];

        prev.next = curr.next;

        return head;
    }
    
    private int getSize(ListNode head) {
        ListNode dummy = head;
        int size = 0;
        
        while (dummy != null) {
            size++;
            dummy = dummy.next;
        }
        
        return size;
    }

    private ListNode[] getPositionNode(ListNode head, int n) {
        int index = 0;

        ListNode dummy = head;
        ListNode prev = head;

        while (dummy != null) {
            if (index == n) {
                return new ListNode[]{prev, dummy};
            }

            prev = dummy;
            dummy = dummy.next;

            index++;
        }

        return new ListNode[]{prev, dummy};
    }
}
