class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low=0,high=cells.length-1,ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(bfs(cells,row,col,mid)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans+1;
    }
    public boolean bfs(int[][] cells,int r,int c,int day){
        int grid[][]=new int[r][c];
        for(int i=0;i<=day;i++){
            grid[cells[i][0]-1][cells[i][1]-1]=1;
        }
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[r][c];
        for(int i=0;i<c;i++){
            if(grid[0][i]==0){
                q.add(new int[]{0,i});
                visited[0][i]=true;
            }
        }
        int[] dx={0,0,1,-1};
        int[] dy={-1,1,0,0};
        while(!q.isEmpty()){
            int size=q.size();
            int[] p=q.poll();
            int r1=p[0];
            int c1=p[1];
            for(int i=0;i<4;i++){
                int x=r1+dx[i];
                int y=c1+dy[i];
                if(x<0 || y<0 || x>r-1 || y>c-1 || visited[x][y] || grid[x][y]==1){
                    continue;
                }
                visited[x][y]=true;
                if(x==r-1)return true;
                q.add(new int[]{x,y});
            }
        }
        return false;
    }
}