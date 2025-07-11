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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l1=list1;
        ListNode l2=list2;
        ListNode temp=null;
        ListNode temp1=l1;
        int count=0;
        while(l1!=null && count<a-1){
            l1=l1.next;
            count++;
        }
        temp1=l1;
        while(temp1!=null && count<b){
            temp1=temp1.next;
            count++;
        }
        temp1=temp1.next;
        l1.next=l2;
        while(l1.next!=null){
            l1=l1.next;
        }
        l1.next=temp1;
        return list1;
    }
}