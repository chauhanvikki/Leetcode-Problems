class Solution {
    class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rotten=0;
        Queue<pair> q=new LinkedList<>();
        int total=0;
        int times=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j));
                    total++;
                }
                else if(grid[i][j]==1)total++;
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            rotten+=size;
            if(rotten==total)return times;
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
                q.remove();
            }
            times++;
        }
        if(rotten==0 && total==0){
            return 0;
        }
        return -1;
    }
}