class Solution {
    class Pair{
        int i;
        int j;
        int cost;
        Pair(int i,int j,int cost){
            this.i=i;
            this.j=j;
            this.cost=cost;
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        pq.add(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int row=curr.i;
            int col=curr.j;
            int cost=curr.cost;
            if(vis[row][col])continue;
            vis[row][col]=true;
            if(row==n-1 && col==n-1)return cost;
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<n){
                    int maxCost=Math.max(cost,grid[nr][nc]);
                    pq.offer(new Pair(nr,nc,maxCost));
                }
            }
        }
        return -1;
    }
}