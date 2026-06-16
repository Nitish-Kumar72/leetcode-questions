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

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        int carry = 0;

        head = reverse(head);
        ListNode curr = head;

        while(curr !=null){
            int val = curr.val * 2 + carry;

            curr.val = val % 10;

            carry = val / 10;

            if(curr.next == null){

            
            if(carry > 0){
                curr.next = new ListNode(carry);
               
            }
            break;
            }
            curr = curr.next;
        }
       
        return reverse(head);


    }
}