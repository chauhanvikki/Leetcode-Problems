class Solution {
    class Pair{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        boolean[] vis=new boolean[points.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        int edgeUse=0;
        int totalCost=0;
        pq.offer(new Pair(0,0));
        while(edgeUse<points.length){
            Pair curr=pq.poll();
            if(vis[curr.node])continue;
            vis[curr.node]=true;
            for(int i=0;i<points.length;i++){
                if(!vis[i]){
                    int cost=Math.abs(points[curr.node][0]-points[i][0])+Math.abs(points[curr.node][1]-points[i][1]);
                    pq.offer(new Pair(i,cost));
                }
            }
            totalCost+=curr.cost;
            edgeUse++;
        }
        return totalCost;
    }
}