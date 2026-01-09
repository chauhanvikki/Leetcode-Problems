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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null)return null;
        int left=dep(root.left);
        int right=dep(root.right);
        if(left==right)return root;
        TreeNode node;
        if(left<right){
            node=subtreeWithAllDeepest(root.right);
        }
        else{
            node=subtreeWithAllDeepest(root.left);
        }
        return node;
    }
    public int dep(TreeNode root){
        if(root==null)return 0;
        int left=1+dep(root.left);
        int right=1+dep(root.right);
        return Math.max(left,right);
    }
}