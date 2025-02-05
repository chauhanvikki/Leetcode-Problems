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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l1=maxDepth(root.left);
        int l2=maxDepth(root.right);
        return max(l1,l2);
    }
    public static int max(int l1,int l2){
        if(l1>l2){
            return l1+1;
        }
        return l2+1;
    }
}