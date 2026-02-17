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
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        int ans=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.offer(new Pair(0,0,grid[0][0]));
        int[] dr={1,-1,0,0};
        int[] dc={0,0,1,-1};
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
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    int newCost=Math.max(grid[nr][nc],cost);
                    pq.offer(new Pair(nr,nc,newCost));
                }
            }
        }
        return -1;
    }
}