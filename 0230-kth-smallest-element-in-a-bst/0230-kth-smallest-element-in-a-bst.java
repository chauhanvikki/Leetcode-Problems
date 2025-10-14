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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls=new ArrayList<>();
        List<Integer> res=helper(root,k,ls);
        return res.get(k-1);
    }
    public List<Integer> helper(TreeNode root,int k,List<Integer> ls){
        if(root==null)return ls;
        helper(root.left,k,ls);
        ls.add(root.val);
        helper(root.right,k,ls);
        return ls;
    }
}