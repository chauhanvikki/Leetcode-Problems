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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        if(root==null)return res;
        int count=0;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.peek();
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                // if(count%2==0){
                    ls.add(curr.val);
                // }
                // else{
                //     st.push(curr.val);
                // }
                q.remove();
            }
            if(count%2 !=0){
                // while(!st.isEmpty()){
                //     ls.add(st.peek());
                //     st.pop();
                // }
                Collections.reverse(ls);
            }
            count++;
            res.add(ls);
        }
        return res;
    }
}