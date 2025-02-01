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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null){
            return head;
        }
        int l=len(head);
        
        k=k%l;
        if(k==0){
            return head;
        }
        ListNode temp=head;
        for(int i=1;i<l-k;i++){
            temp=temp.next;
        }
        ListNode newHead=temp.next;
        temp.next=null;
        ListNode last=newHead;
        while(last.next!=null){
            last=last.next;
        }
        last.next=head;
        return newHead;
    }
    static int len(ListNode temp){
        int l=0;
        while(temp!=null){
            l++;
            temp=temp.next;
        }
        return l;
    }
}