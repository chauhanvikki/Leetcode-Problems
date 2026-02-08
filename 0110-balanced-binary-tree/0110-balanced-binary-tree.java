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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return dfs(root)!=-1;
    }
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int h1=dfs(node.left);
        if(h1==-1)return -1;
        int h2=dfs(node.right);
        if(h2==-1)return -1;
        if(Math.abs(h1-h2)>1)return -1;
        return Math.max(h1,h2)+1;
    }
}