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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return new TreeNode(head.val);
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            prev=prev.next;
        }
        ListNode l2=slow.next;
        slow.next=null;
        prev.next=null;
        ListNode l1=head;
        TreeNode root=new TreeNode(slow.val);
        if(l1!=null)root.left=sortedListToBST(l1);
        if(l2!=null)root.right=sortedListToBST(l2);
        return root;
    }
}