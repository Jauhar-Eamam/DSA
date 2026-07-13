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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode lastCurrent = null;

        if (head == null) {
            return head;
        }

        int possition = 1;

        while (current != null && current.next != null) {

            if ((possition == left)) {
                ListNode leftNode = current;
                ListNode previous = current;
                ListNode forward = current.next;

                while (possition != right) {
                    ListNode temp = forward.next;

                    forward.next = previous;

                    previous = forward;
                    forward = temp;
                    possition++;
                }

                leftNode.next = forward;

                if (lastCurrent != null) {
                    lastCurrent.next = previous;

                    return head;
                } else {
                    return previous;
                }

            } else {
                lastCurrent = current;
                current = current.next;
                possition++;
            }

        }

        return head;
    }
}