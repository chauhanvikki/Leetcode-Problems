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
    int idx=0;
    public TreeNode balanceBST(TreeNode root) {
        int l=len(root);
        int[] sort=new int[l];
        helper(root,sort);
        int i=0;
        int j=sort.length-1;
        return bal(i,j,sort);
    }
    public int len(TreeNode node) {
        if (node == null) return 0;
        return 1 + len(node.left) + len(node.right);
    }
    public TreeNode bal(int i,int j,int[] sort){
        if(i>j)return null;
        int m=(j+i)/2;
        TreeNode root=new TreeNode(sort[m]);
        root.left=bal(i,m-1,sort);
        root.right=bal(m+1,j,sort);
        return root;
    }
    public void helper(TreeNode root,int[] sort){
        if(root==null){
            return; 
        }
        helper(root.left,sort);
        sort[idx++]=root.val;
        helper(root.right,sort);
    }
}