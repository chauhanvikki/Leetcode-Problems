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
        if(head==null)return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode prev=dummy;
        while(fast!=null){
            if(slow.val==fast.val){
                while(fast!=null && slow.val==fast.val){
                    fast=fast.next;
                }
                slow=fast;
                if(fast!=null)fast=fast.next;
                prev.next=slow;
                // prev=prev.next;
            }
            else{        
                slow=slow.next;
                fast=fast.next;
                prev=prev.next;
            }
        }
        return dummy.next;
    }
}