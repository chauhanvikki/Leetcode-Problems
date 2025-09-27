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
        
        ListNode head=null;
        ListNode temp=null;
        while(l1!=null || l2!=null || carry>0){
            int val1=(l1!=null)?l1.val:0;
            int val2=(l2!=null)?l2.val:0;
            int value=val1+val2+carry;
                carry=value/10;
                value=value%10;
            ListNode curr=new ListNode(value);
            if(head==null){
                head=curr;
                temp=curr;
            }
            else{
                temp.next=curr;
                temp=temp.next;
            }
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        return head;
    }
}