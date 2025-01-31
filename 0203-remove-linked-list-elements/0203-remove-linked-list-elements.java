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
    public ListNode removeElements(ListNode head, int val) {
        // if(head==null|| (head.next==null&& head.val!=val)) return head;
        // ListNode newHead=new ListNode(0), curr=newHead;
        // newHead.next=head;
        // while(curr.next!=null){
        //     if(curr.next.val==val)curr.next=curr.next.next;
        //     else curr=curr.next;
        // }
        // return newHead.next;
        if(head==null){
            return head;
        }
        ListNode dummy= new ListNode(0);
        ListNode curr=dummy;
        dummy.next=head;
        while(curr.next!=null){
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }else{
            curr=curr.next;
        }
        }
        return dummy.next;
    }
}
