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
        ListNode fast=head;
        ListNode slow=head;
        // int count=count(head);
        if(n==1 && slow.next==null)return null;
        int k=1;
        if(head==null)return null;
        while(fast.next!=null){
            if(k<=n){
                fast=fast.next;
            
            }
            else{
                fast=fast.next;
                slow=slow.next;
            }
            k++;
        }
        if(k==n)return head.next;
        if(n==1){
            slow.next=null;
        }
        else{
            slow.next=slow.next.next;
        }
        return head;
    }
    // public static int count(ListNode l){
    //     int c=1;
    //     while(l!=null){
    //         c++;
    //         l=l.next;
    //     }
    //     return c;
    // }
}