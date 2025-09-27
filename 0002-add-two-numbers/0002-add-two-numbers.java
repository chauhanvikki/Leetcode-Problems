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
        int carry=0;
        ListNode temp=null;
        ListNode head=null;
        while(carry!=0 || l1!=null || l2!=null){
            int val1=(l1!=null)?val1=l1.val:0;
            int val2=(l2!=null)?val2=l2.val:0;
            int val=val1+val2+carry;
            carry=val/10;
            int value=(val)%10;
            ListNode curr=new ListNode(value);
            if(head==null){
                head=curr;
                temp=curr;
            }
            else{
                temp.next=curr;
                temp=temp.next;
            }
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return head;
    }
}