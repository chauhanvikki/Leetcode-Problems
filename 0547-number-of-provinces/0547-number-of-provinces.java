class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean vis[]=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        int count=0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]!=true){
                count++;
                bfs(adj,vis,n,i);
            }
        }
        return count;
    }
    public void bfs(List<List<Integer>> adj, boolean vis[], int n,int src){
         vis[src]=true;
         Queue<Integer> q=new LinkedList<>();
         q.add(src);
         while(!q.isEmpty()){
            int curr=q.remove();
            if(vis[curr]==false){
                vis[curr]=true;
            }
            for(int j=0;j<adj.get(curr).size();j++){
                if(adj.get(curr).get(j)!=curr && vis[adj.get(curr).get(j)]==false){
                    q.add(adj.get(curr).get(j));
                }
            }
         }
         return;
    }
}