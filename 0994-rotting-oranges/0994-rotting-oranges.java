class Solution {
    static class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int total=0;
        int time=0;
        int rotten=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new pair(i,j));
                    total++;
                }
                if(grid[i][j]==1){
                    total++;
                }
            }
        }
        if(total==0){
            return 0;
        }
            while(!q.isEmpty()){
                int size=q.size();
                rotten+=size;
                
                if(rotten==total){
                   return time;
                }
                time++;
                for(int i=0;i<size;i++){
                pair p=q.peek();
                if(p.x-1>=0 && grid[p.x-1][p.y]==1){
                    grid[p.x-1][p.y]=2;
                    q.offer(new pair(p.x-1,p.y));
                }
                if(p.x+1<m && grid[p.x+1][p.y]==1){
                    grid[p.x+1][p.y]=2;
                    q.offer(new pair(p.x+1,p.y));
                }
                if(p.y-1>=0 && grid[p.x][p.y-1]==1){
                    grid[p.x][p.y-1]=2;
                    q.offer(new pair(p.x,p.y-1));
                }
                if(p.y+1<n && grid[p.x][p.y+1]==1){
                    grid[p.x][p.y+1]=2;
                    q.offer(new pair(p.x,p.y+1));
                }
                q.poll();
                }
            }
            return -1;
    }
}