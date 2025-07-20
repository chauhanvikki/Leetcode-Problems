class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[]=new int[n];
        for(int i=0; i<n;i++){
            if(i==src){
                dist[i]=0;
            }
            else{
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<k+1;i++){
            int temp[]=dist.clone();
            for(int[] flight:flights){
                int u=flight[0];
                int v=flight[1];
                int cost=flight[2];

                if(dist[u]!=Integer.MAX_VALUE &&  dist[u] + cost < temp[v]){
                    temp[v]=dist[u]+cost;
                }
            }
            dist=temp;
        }
        if(dist[dst]==Integer.MAX_VALUE){
                return -1;
        }
        return dist[dst];
    }
}