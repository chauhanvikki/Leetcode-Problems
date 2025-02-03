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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> n=new ArrayList<>();
        helper(root,n);
        return n;
    }
    static void helper(TreeNode root,ArrayList<Integer> n){
        if(root==null){
            return;
        }
        helper(root.left,n);
        n.add(root.val);
        helper(root.right,n);
    }
}