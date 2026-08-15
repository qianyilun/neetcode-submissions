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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d1 = l1;
        ListNode d2 = l2;

        int addExtra = 0;

        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        while (d1 != null && d2 != null) {
            int sum = d1.val + d2.val + addExtra;

            if (sum >= 10) {
                dummy.next = new ListNode(sum % 10);
                addExtra = 1;
            } else {
                dummy.next = new ListNode(sum);
                addExtra = 0;
            }
            
            dummy = dummy.next;
            d1 = d1.next;
            d2 = d2.next;
        }
        
        while (d1 != null) {
            int sum = d1.val + addExtra;

            if (sum >= 10) {
                dummy.next = new ListNode(sum % 10);
                addExtra = 1;
            } else {
                dummy.next = new ListNode(sum);
                addExtra = 0;
            }
            
            dummy = dummy.next;
            d1 = d1.next;
        }

        while (d2 != null) {
            int sum = d2.val + addExtra;

            if (sum >= 10) {
                dummy.next = new ListNode(sum % 10);
                addExtra = 1;
            } else {
                dummy.next = new ListNode(sum);
                addExtra = 0;
            }

            dummy = dummy.next;
            d2 = d2.next;
        }
        
        if (addExtra > 0) {
            dummy.next = new ListNode(addExtra);
        }

        return result.next;
    }
}
