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
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculate(root);
        return result;
    }
    public int calculate(TreeNode root){
        if(root==null)return 0;
        int l=Math.max(calculate(root.left),0);
        int r=Math.max(calculate(root.right),0);
        result=Math.max(root.val+l+r,result);
        return root.val+Math.max(l,r);
    }
}