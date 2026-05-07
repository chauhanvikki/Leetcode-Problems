/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(sb.length()>0)sb.append(",");
            if(curr==null)sb.append("n");
            else{
                sb.append(curr.val);
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty() || data==null)return null;
        String[] parts=data.split(",");
        TreeNode parent=new TreeNode(Integer.parseInt(parts[0]));
        int i=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(parent);
        while(!q.isEmpty() && i<parts.length){
            TreeNode node=q.poll();
            if(i<parts.length && !parts[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(parts[i]));
                node.left=left;
                q.offer(left);
            }
            i++;
            if(i<parts.length && !parts[i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(parts[i]));
                node.right=right;
                q.offer(right);
            }
            i++;
        }
        return parent;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));