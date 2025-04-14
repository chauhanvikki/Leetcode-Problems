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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        while(temp.next!=null && temp.next.next!=null){
            ListNode curr1=temp.next;
            ListNode curr2=temp.next.next;
            curr1.next=curr2.next;
            curr2.next=curr1;
            temp.next=curr2;
            temp=curr1;
        }
        return dummy.next;
    }
}