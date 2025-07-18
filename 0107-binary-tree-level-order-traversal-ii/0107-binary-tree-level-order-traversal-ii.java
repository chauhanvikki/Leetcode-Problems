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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.peek();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                ls.add(curr.val);
                q.remove();
            }
            res.add(ls);
        }
        List<List<Integer>> finalList=new ArrayList<>();
        for(int i=res.size()-1;i>=0;i--){
            finalList.add(res.get(i));
        } 
        return finalList;
    }
}