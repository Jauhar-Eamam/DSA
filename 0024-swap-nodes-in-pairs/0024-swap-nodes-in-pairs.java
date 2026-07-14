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
    public ListNode swapPairs(ListNode head) {

            if(head == null) {
                return head;
            }
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode newHead = curr;

        while (prev.next != null) {
            ListNode temp = curr.next;

            curr.next = prev;
            if (temp == null) {
                prev.next = temp;
                return newHead;
            } else if (temp.next == null) {
                prev.next = temp;
                return newHead;
            }
            prev.next = temp.next;

            prev = temp;
            curr = temp.next;
        }

        return head;

    }
}