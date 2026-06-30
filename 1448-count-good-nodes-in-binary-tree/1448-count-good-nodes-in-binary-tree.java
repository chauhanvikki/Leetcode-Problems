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
    public int goodNodes(TreeNode root) {
        return dfs(root,0,Integer.MIN_VALUE);
    }
    public int dfs(TreeNode node,int count,int prev){
        if(node==null)return 0;
        if(node.val>=prev)count++;
        else count=0;
        count+=dfs(node.left,0,Math.max(prev,node.val));
        count+=dfs(node.right,0,Math.max(prev,node.val));
        return count;
    }
}