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
    public ListNode removeNodes(ListNode head) {
        ListNode rev=rev(head);
        int max=rev.val;
        ListNode curr=rev.next;
        ListNode prev=rev;

        while(curr!=null){
            if(max>curr.val){
                prev.next=curr.next;
            }
            else{
                max=curr.val;
                prev=curr;
            }
            curr=curr.next;
        }
        return rev(rev);
    }
    public ListNode rev(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}