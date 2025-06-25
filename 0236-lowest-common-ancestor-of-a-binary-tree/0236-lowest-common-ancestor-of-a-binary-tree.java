/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q){
            return root;
        }
        boolean pExist=exist(root.left,p);
        boolean qExist=exist(root.left,q);
        if(pExist==true && qExist==true){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(pExist==false && qExist==false){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    private boolean exist(TreeNode root,TreeNode node){
        if(root==node){
            return true;
        }
        if(root==null){
            return false;
        }
        return exist(root.left,node)||exist(root.right,node);
    }
}