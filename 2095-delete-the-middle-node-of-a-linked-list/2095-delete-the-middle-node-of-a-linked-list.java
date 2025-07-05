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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null )return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        dummy.next=head;
        while(fast!=null && fast.next!=null){
            prev=prev.next;
            slow=slow.next;
            fast=fast.next.next;
            prev.next=slow;
        }
        prev.next=slow.next;
        prev=prev.next;
        return dummy.next;
    }
}