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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean x_found=false;
            boolean y_found=false;
            List<Integer> ls=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                if(curr.val==x)x_found=true;
                if(curr.val==y)y_found=true;
                if(curr.left!=null && curr.right!=null){
                    int r=curr.right.val;
                    int l=curr.left.val;
                    if((r==x && y==l) || (r==y && l==x)){
                        return false;
                    }
                }
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right); 
                ls.add(curr.val);
                
            }
            if(ls.contains(x) && ls.contains(y)){
                return true;
            }
        }
        return false;
    }
}