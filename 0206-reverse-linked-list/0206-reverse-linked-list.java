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
    public ListNode reverseList(ListNode head) {
        ListNode lastNode = head;
        if(lastNode == null) {
            return head;
        }
        ListNode currNode = lastNode.next;
        lastNode.next = null;
        ListNode tempNode;

        while(currNode != null) {
            tempNode = currNode.next;
            currNode.next = lastNode;
            lastNode = currNode;
            currNode = tempNode;
        }

        return lastNode;
    }
}