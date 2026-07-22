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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode lastPrevNode = null;

        ListNode prev = null;
        ListNode lastPrev = null;

        ListNode forSize = head;

        int i = 1;

        while (curr != null) {

            int size = 0;

            while (forSize != null) {
                size++;

                forSize = forSize.next;

                if (size == i) {
                    break;
                }

            }

            if (size < i) {
                i = size;
            }

            if (i % 2 != 0) {
                for (int j = 0; j < i; j++) {
                    lastPrevNode = curr;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                lastPrev = prev;
                curr = prev.next;
                prev.next = null;

                for (int j = 1; j < i; j++) {

                    ListNode temp = curr.next;

                    curr.next = prev;

                    prev = curr;
                    curr = temp;
                }

                lastPrev.next = curr;
                lastPrevNode.next = prev;
                lastPrevNode = lastPrev;
            }

            i++;
        }

        return head;

    }
}