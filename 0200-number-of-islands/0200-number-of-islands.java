class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int island=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    // vis[i][j]=true;
                    island++;
                    dfs(grid,vis,m,n,i,j);
                }
            }
        }
        return island;
    }
    public static void dfs(char[][] grid,boolean vis[][], int m,int n,int row,int col){
        vis[row][col]=true;
        if(row-1 >= 0 && grid[row-1][col]=='1'&& !vis[row-1][col]){
            dfs(grid,vis,m,n,row-1,col);
        }
        if(row+1 < m && grid[row+1][col]=='1'&& !vis[row+1][col]){
            dfs(grid,vis,m,n,row+1,col);
        }
        if(col-1 >= 0 && grid[row][col-1]=='1'&& !vis[row][col-1]){
            dfs(grid,vis,m,n,row,col-1);
        }
        if(col+1 < n && grid[row][col+1]=='1'&& !vis[row][col+1]){
            dfs(grid,vis,m,n,row,col+1);
        }
    }
}