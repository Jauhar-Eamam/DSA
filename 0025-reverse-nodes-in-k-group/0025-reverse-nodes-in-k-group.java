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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1){
            return head;
        }

     ListNode right = head;
     ListNode left = head;

     ListNode nextNode = null;
     ListNode lastLeft = left;

     ListNode resultNode = null;

     ListNode curr = head;
    //  left.next = null;

     int size = 0;

     while(curr != null){
        size++;

        curr = curr.next;
     }

     int terms = (int) size / k;

     int term = 0;


     while(terms > term){

        ListNode currLastNode = left;

        for(int i = 0; i <= (k-1); i++){
            if(i == 0){
                right = right.next;
                left.next = null;
                continue;
            }
            nextNode = right.next;

            right.next = left;

            left = right;
            right = nextNode;
        }

        if(resultNode == null){
            resultNode = left;

            left = nextNode;

        }else {
            lastLeft.next = left;

            lastLeft = currLastNode;

            left = nextNode;
        }

        term++;
     }

     if(right != null){
        lastLeft.next = right;
     }

     return resultNode;
     

        
    }
}