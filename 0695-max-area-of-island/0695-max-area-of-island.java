class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int count=dfs(grid,i,j,visited);
                    ans=Math.max(ans,count);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int row,int col,boolean[][] visited){
        if(row>=grid.length || col>=grid[0].length || row<0 || col<0){
            return 0;
        }
        if(visited[row][col] || grid[row][col]==0){
            return 0;
        }
        visited[row][col]=true;
        int count=1;
        count+=dfs(grid,row+1,col,visited);
        count+=dfs(grid,row-1,col,visited);
        count+=dfs(grid,row,col+1,visited);
        count+=dfs(grid,row,col-1,visited);
        return count;
    }
}