/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)return root;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node dummy = new Node(0);
            Node nn = dummy;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.peek();
                nn.next=curr;
                nn=nn.next;
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                q.remove();
            }
            nn.next=null;
        }
        return root;
    }
}