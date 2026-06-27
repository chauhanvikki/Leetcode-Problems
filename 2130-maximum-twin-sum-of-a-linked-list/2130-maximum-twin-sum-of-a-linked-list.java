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
    public int pairSum(ListNode head) {
        if(head==null)return 0;
        ListNode slow=head;
        ListNode fast=head;
        int ans=0;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode second=reverse(slow);
        while(head!=null && second!=null){
            ans=Math.max(head.val+second.val,ans);
            second=second.next;
            head=head.next;
        }
        return ans;
    }
    public ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode temp=node;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}