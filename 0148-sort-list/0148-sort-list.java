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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=head;
        ListNode prev=new ListNode(0);
        prev.next=temp;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            prev=prev.next;
        }
        ListNode l2=sortList(slow);
        prev.next=null;
        ListNode l1=sortList(temp);
        return merge(l1,l2);
    }

    public ListNode merge(ListNode first, ListNode second){
        ListNode temp1=first;
        ListNode temp2=second;
        ListNode nn=new ListNode(0);
        ListNode dummy=nn;
        while(temp1!=null && temp2!=null){
            if(temp1.val < temp2.val){
                nn.next=new ListNode(temp1.val);
                temp1=temp1.next;
            }
            else{
                nn.next=new ListNode(temp2.val);
                temp2=temp2.next;
            }
            nn=nn.next;
        }
        while(temp1!=null){
            nn.next=new ListNode(temp1.val);
            temp1=temp1.next;
            nn=nn.next;
        }
        while(temp2!=null){
            nn.next=new ListNode(temp2.val);
            temp2=temp2.next;
            nn=nn.next;
        }
        return dummy.next;
    }
}