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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k == 0){
            return head;
        }

        ListNode startNode = head;
        ListNode currNode = head;

        int size = 0;

        while(currNode != null) {
            size++;

            currNode = currNode.next;
        }

        currNode = head;

        if(k > size){
            k = (int) k%size;
        }else if(k == size){
            return head;
        }

        if(k == 0 ){
            return head;
        }

        for(int i = 1; i < size-k; i++){
            currNode = currNode.next;
        }

        ListNode nextNode = currNode.next;

        currNode.next = null;

        ListNode resultNode = nextNode;

        while(nextNode.next != null){
            nextNode = nextNode.next;
        }

        nextNode.next = startNode;

        return resultNode;
        
    }
}