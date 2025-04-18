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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        helper(res,ls,root,targetSum);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> ls, TreeNode node, int target){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null && target-node.val==0){
            ls.add(node.val);
            res.add(new ArrayList<>(ls));
            ls.remove(ls.size()-1);
            return;
        }
        ls.add(node.val);
        helper(res,ls,node.left,target-node.val);
        helper(res,ls,node.right,target-node.val);
        ls.remove(ls.size()-1);
    }
}