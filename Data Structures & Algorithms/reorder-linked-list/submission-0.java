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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        
        ListNode mid = findMid(head);
        
        // 断开
        ListNode rightPart = mid.next;
        mid.next = null;
        ListNode newRightPart = reverseLinkedList(rightPart);
        
        ListNode dummy1 = head;
        ListNode dummy2 = newRightPart;
        
        while (dummy1 != null && dummy2 != null) {
            ListNode dummy1Next = dummy1.next;
            ListNode dummy2Next = dummy2.next;
            
            dummy1.next = dummy2;
            dummy2.next = dummy1Next;
            
            dummy1 = dummy1Next;
            dummy2 = dummy2Next;
        }
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null) {
            if (fast.next == null) {
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverseLinkedList(ListNode head) {
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
