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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Double> ls=new ArrayList<>();
        if(root==null){
            return ls;
        }
        long sum=0;
        q.add(root);
        while(!q.isEmpty()){
            long size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.peek();
                sum+=curr.val;
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                q.remove();
            }
            double res=(double)sum/(double)size;
            ls.add(res);
            sum=0;
        }
        return ls;
    }
}