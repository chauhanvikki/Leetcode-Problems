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
        int s1=size(l1);
        int s2=size(l2);
        int s=Math.max(s1,s2);
        ListNode head=null;
        ListNode temp=null;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int val1=(l1!=null)?l1.val:0;
            int val2=(l2!=null)?l2.val:0;
            int valu=val1+val2+carry;
            ListNode nn=new ListNode(valu%10);
            if(head==null){
                head=nn;
                temp=nn;
            }
            else{
                temp.next=nn;
                temp=temp.next;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            carry=valu/10;
        }
        return head;
    }
    public int size(ListNode l){
        int count=0;
        while(l!=null){
            count++;
            l=l.next;
        }
        return count;
    }
}