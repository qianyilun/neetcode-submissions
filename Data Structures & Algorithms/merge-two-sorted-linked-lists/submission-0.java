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
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummy1 = list1;
        ListNode dummy2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        
        while (dummy1 != null && dummy2 != null) {
            if (dummy1.val < dummy2.val) {
                dummy.next = new ListNode(dummy1.val);
                
                dummy1 = dummy1.next;
            } else {
                dummy.next = new ListNode(dummy2.val);

                dummy2 = dummy2.next;
            }
            
            dummy = dummy.next;
        }
        
        while (dummy1 != null) {
            dummy.next = new ListNode(dummy1.val);
            
            dummy1 = dummy1.next;
            dummy = dummy.next;
        }

        while (dummy2 != null) {
            dummy.next = new ListNode(dummy2.val);

            dummy2 = dummy2.next;
            dummy = dummy.next;
        }
        
        return dummyHead.next;
    }
}