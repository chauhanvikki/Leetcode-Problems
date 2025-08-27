class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return path(grid,dp,0,m,n,0,0);
    }
    public int path(int[][] grid, int[][] dp,int sum,int m, int n,int a,int b){
        if(a>=m || b>=n){
            return Integer.MAX_VALUE; 
        }
        if(a==m-1 && b==n-1)return grid[a][b];
        if(dp[a][b]!=-1){
            return dp[a][b];
        }
        int right=path(grid,dp,sum,m,n,a+1,b);
        int down=path(grid,dp,sum,m,n,a,b+1);
        return dp[a][b]=grid[a][b]+Math.min(right,down);
    }
}