class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int a=obstacleGrid.length;
        int b=obstacleGrid[0].length;
        int[][] dp=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                dp[i][j]=-1;
            }
        }
        return helper(obstacleGrid,dp,a,b,0,0);
    }
    public int helper(int[][] obstacle,int[][] dp,int a, int b,int m,int n){
        if(m==a-1 && n==b-1)return 1;
        if(m>=a || n>=b)return 0;
        if(obstacle[m][n]==1)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        return dp[m][n]=helper(obstacle, dp,a,b,m+1,n)+helper(obstacle, dp,a,b,m,n+1);
    }
}