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
    public static void inorder(TreeNode root,List<Integer> in){
        if(root==null){
            return;
        }
        inorder(root.left,in);
        in.add(root.val);
        inorder(root.right,in);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> in=new ArrayList<>();
        inorder(root,in);
        return construct(in,0,in.size()-1);
    }
    private TreeNode construct(List<Integer> in,int s,int e){
        if(s>e){
            return null;
        }
        int m=s+(e-s)/2;
        TreeNode root=new TreeNode(in.get(m));
        root.left=construct(in,s,m-1);
        root.right=construct(in,m+1,e);
        return root;
    }
}