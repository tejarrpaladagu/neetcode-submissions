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
        int k = n;
        ListNode slow = head;
        ListNode fast = head;

        while (k!=0){
            fast = fast.next;
            k--;

        }
        if (fast == null) {
            return head.next; // Safely bypasses the first node and returns the new head
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;

    }
}
