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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)return;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode dummy=slow.next;
        slow.next=null;
        ListNode rev=reverse(dummy);
        ListNode start=head;
        dummy=rev;
        int count=0;
        while(dummy!=null){
            ListNode temp2=dummy.next;
            ListNode temp1=start.next;
            
            start.next=dummy;
            dummy.next=temp1;

            start=temp1;
            dummy=temp2;
        }
        return;
    }
    public ListNode reverse(ListNode l){
        ListNode prev=null;
        ListNode curr=l;
        while(curr!=null){
            ListNode nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
}