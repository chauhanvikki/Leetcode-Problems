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
    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<=l2.val){
            l1.next=mergeTwoList(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoList(l1,l2.next);
            return l2;
        }
    }

    public ListNode partitionAndMerge(int start,int end,ListNode[] l){
        if(start>end)return null;
        if(start==end)return l[start];
        int mid=start+(end-start)/2;
        ListNode l1=partitionAndMerge(start,mid,l);
        ListNode l2=partitionAndMerge(mid+1,end,l);
        return mergeTwoList(l1,l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return partitionAndMerge(0,lists.length-1,lists);
    }
}