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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode nextNode = curr.next;

        while(nextNode != null) {
            if(curr.val == nextNode.val) {
                nextNode = nextNode.next;
            }
            else {
                curr.next = nextNode;
                curr = nextNode;
                nextNode = nextNode.next;
            }
        }
        curr.next = nextNode;

        return head;
    }
}