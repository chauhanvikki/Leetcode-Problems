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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> n=new ArrayList<>();
        helper(root,n);
        return n;
    }
    public void helper(TreeNode root,List<Integer> n){
        if(root==null){
            return;
        }
        n.add(root.val);
        helper(root.left,n);
        helper(root.right,n);
    }
}