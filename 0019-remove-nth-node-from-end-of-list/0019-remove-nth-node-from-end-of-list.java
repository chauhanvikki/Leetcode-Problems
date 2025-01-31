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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=len(head);
        if(length==n){
            return head.next;
        }
        ListNode a=head;
        for(int i=1;i<length-n;i++){
            a=a.next;
        }  
        a.next=a.next.next;  
        return head;
    }
    static int len(ListNode head){
        ListNode temp=head;
        int l=0;
        while(temp != null){
            l++;
            temp=temp.next;
        }
        return l;
    }
}