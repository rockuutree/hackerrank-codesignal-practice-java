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
//  Reverse the second half of the linkedlist
// Merge the start and reversed second half one by one
class Solution {
    public void reorderList(ListNode head) {
        // Base case if the head is empty or has only one value
        if(head == null || head.next == null) {
            return;
        }

        // Step 1: Cut the list into two halfs (middlepoint)
        //  Slow = head of 2nd half
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // Moves at 2x
        }

        // Second half is the next of slow.
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;

        // Reverses the second half of the linked list
        while(second != null) {
            // Temp to hold the next in second
            ListNode temp = second.next;
            // Point the next for the current to prev
            second.next = prev;
            prev = second;
            // Current is now set to the next in the list
            second = temp;
        }

        // Set the first half to head;
        ListNode first = head;
        // Second half is now set to previous (reversed linkedlist)
        second = prev;

        // Merging the linkedlists
        // First will be longer bc it contains all, eventually second will be the last and point to null
        while (second != null) {
            // Breaking the lists so we need to store the next
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // placing second between first and first.next;
            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }


        

        

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;

            if (n1 == null) {
                break;
            }

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}