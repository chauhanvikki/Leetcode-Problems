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
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        // int length=count(head);
        ListNode temp1=head;
        ListNode temp2=head;
        // ListNode temp3=temp1.next;
        while(temp2!=null && temp2.next!=null){
            temp1=temp1.next;
            temp2=temp2.next.next;
            // temp3=temp3.next;
        }
        // if(length%2==0){
        //      return temp3;
        // }
        return temp1;
    }
    // public int count(ListNode c){
    //     int l=0;
    //     while(c!=null){
    //         c=c.next;
    //         l++;
    //     }
    //     return l;
    // }
}