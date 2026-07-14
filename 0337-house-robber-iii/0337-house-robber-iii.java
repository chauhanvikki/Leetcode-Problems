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
// class Solution {
//     public int rob(TreeNode root) {
//         return dfs(root,false);
//     }
//     public int dfs(TreeNode node,boolean isParent){
//         if(node==null)return 0;
//         if(isParent){
//             return dfs(node.left,false)+dfs(node.right,false);
//         }
//         int rob=node.val+dfs(node.left,true)+dfs(node.right,true);
//         int noRob=dfs(node.left,false)+dfs(node.right,false);
//         return Math.max(rob,noRob);
//     }
// }
class Solution{
    public int rob(TreeNode root){
        if(root==null)return 0;
        int ans[]=dfs(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] dfs(TreeNode node){
        if(node==null){
            return new int[]{0,0};
        }
        int[] left=dfs(node.left);
        int[] right=dfs(node.right);
        
        int rob=node.val+left[1]+right[1];
        int NoRob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{rob,NoRob};
    }
}