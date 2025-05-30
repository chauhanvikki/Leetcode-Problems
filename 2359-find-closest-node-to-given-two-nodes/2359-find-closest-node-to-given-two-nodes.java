class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1=new int[edges.length];
        int[] dist2=new int[edges.length];
        for(int i=0;i<edges.length;i++){
            dist1[i]=Integer.MAX_VALUE;
            dist2[i]=Integer.MAX_VALUE;
        }
        boolean[] vis1=new boolean[edges.length];
        boolean[] vis2=new boolean[edges.length];

        dfs(edges,node1,0,dist1,vis1);
        dfs(edges,node2,0,dist2,vis2);

        int minVal=Integer.MAX_VALUE;
        int result=-1;
        for(int i=0;i<edges.length;i++){
            if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE){
                int maxVal=Math.max(dist1[i],dist2[i]);
                if(maxVal<minVal){
                    minVal=maxVal;
                    result=i;
                }
                else if(maxVal==minVal && result>i){
                    result=i;
                }
            }
        }
        return result;     
    }
    private void dfs(int[] edges,int node,int depth,int[] dist,boolean vis[]){
        if(node==-1 || vis[node]){
            return;
        }
        vis[node]=true;
        dist[node]=depth;
        dfs(edges,edges[node],depth+1,dist,vis);
    }
}