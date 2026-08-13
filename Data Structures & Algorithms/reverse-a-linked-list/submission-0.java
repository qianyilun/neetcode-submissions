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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = head;
        ListNode prev = null;

        while (dummy != null) {
            ListNode next = dummy.next;

            dummy.next = prev;

            prev = dummy;
            dummy = next;
        }

        return prev;
    }
}
