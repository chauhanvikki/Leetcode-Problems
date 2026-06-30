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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if(l1==null && l2==null)return new ListNode(0);
        if(l1==null)return l2;
        if(l2==null)return l1;
        // ListNode first=reverse(l1);
        // ListNode second=reverse(l2);
        ListNode first=l1;
        ListNode second=l2;
        ListNode result=new ListNode((first.val+second.val)%10);
        ListNode dummy=result;
        int carry=(first.val+second.val)/10;
        first=first.next;
        second=second.next;
        while(first!=null && second!=null){
            // carry=(first.val+second.val+carry)/10;
            ListNode curr=new ListNode((first.val+second.val+carry)%10);
            carry=(first.val+second.val+carry)/10;
            dummy.next=curr;
            dummy=dummy.next;
            first=first.next;
            second=second.next;
        }
        while(first!=null){
            // carry=(first.val+carry)/10;
            ListNode curr=new ListNode((first.val+carry)%10);
            carry=(first.val+carry)/10;
            dummy.next=curr;
            dummy=dummy.next;
            first=first.next;
        }
        while(second!=null){
            // carry=(second.val+carry)/10;
            ListNode curr=new ListNode((second.val+carry)%10);
            carry=(second.val+carry)/10;
            dummy.next=curr;
            dummy=dummy.next;
            second=second.next;
        }
        if(carry!=0)dummy.next=new ListNode(carry);
        return (result);
    }
    public ListNode reverse(ListNode l){
        ListNode prev=null;
        while(l!=null){
            ListNode next=l.next;
            l.next=prev;
            prev=l;
            l=next;
        }
        return prev;
    }
}