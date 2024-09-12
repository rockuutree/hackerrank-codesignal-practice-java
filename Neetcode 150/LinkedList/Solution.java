/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow_pointer = head;
        ListNode fast_pointer = head;
        // Loops until the fast_pointer is not null, but if there is a cycle then that should never be the case
        while(fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            // Keep going until the slow pointer runs into the fast pointer
            if(slow_pointer == fast_pointer) {
                return true;
            }
        }

        // if fast_pointer reaches the end, then it doesn't loop, meaning we return false;

        return false;
    }
}