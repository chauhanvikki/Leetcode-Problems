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
    long maxi=Long.MIN_VALUE;
    int MOD=1000000007;
    public int maxProduct(TreeNode root) {
        long totalSum=total(root);
        dfs(root,totalSum);
        return (int)(maxi%MOD);
    }
    public long dfs(TreeNode node,long total){
        if(node==null)return 0;
        long left=dfs(node.left,total);
        long right=dfs(node.right,total);
        long curr=left+right+node.val;
        maxi=Math.max(maxi,(total-curr)*curr);
        return curr;
    }
    public long total(TreeNode node){
        if(node==null)return 0;
        long left=total(node.left);
        long right=total(node.right);
        return node.val+left+right;
    }
}