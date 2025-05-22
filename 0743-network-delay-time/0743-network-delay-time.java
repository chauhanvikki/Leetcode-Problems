class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }        
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair> graph[]=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int time[]:times){
            graph[time[0]].add(new Pair(time[1],time[2]));
        }
       PriorityQueue<Pair> pq=new PriorityQueue<>();
       int dist[]=new int[n+1];
       for(int i=1;i<=n;i++){
        if(i!=k){
            dist[i]=Integer.MAX_VALUE;
        }
       }
       boolean vis[]=new boolean[n];
       pq.add(new Pair(k,0));

       while(!pq.isEmpty()){
        Pair curr=pq.remove();
        int u=curr.node;
        for(Pair neighbour : graph[u]){
           int v=neighbour.node;
            int w=neighbour.dist;

            if(dist[u]+w<dist[v]){
                dist[v]=dist[u]+w;
                pq.add(new Pair(v,dist[v]));
            }
            }
        }
        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime;
       }
}