class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> q=new LinkedList<>();
        List<List<Integer>> ls=new ArrayList<>();
        q.add(source);
        boolean[] vis=new boolean[n];
        vis[source]=true;
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int u=edge[0];
            int v=edge[1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(curr==destination){
                    return true;
                }
                for(int neighbor : ls.get(curr)){
                    if(!vis[neighbor]){
                        vis[neighbor]=true;
                        q.add(neighbor);
                    }
                }
            }
        }
        return false;
    }
}