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
    public ListNode partition(ListNode head, int x) {
        // ListNode dummy=new ListNode(0);
        ListNode smaller=new ListNode(0);
        ListNode dummy=smaller;
        ListNode greater=new ListNode(0);
        ListNode connect=null;
        int count=1;
        while(head!=null){
            if(head.val<x){
                smaller.next=new ListNode(head.val);
                head=head.next;
                smaller=smaller.next;
            }
            else{
                greater.next=new ListNode(head.val);
                greater=greater.next;
                if(count==1){
                    connect=greater;
                    count++;
                }
                head=head.next;
            }
        }
        smaller.next=connect;
        return dummy.next;
    }
}