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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return diameter;
    }
    public int calculate(TreeNode root){
        if(root==null)return 0;
        int l=calculate(root.left);
        int r=calculate(root.right);
        diameter=Math.max((l+r),diameter);
        return 1+Math.max(l,r);
    }
}