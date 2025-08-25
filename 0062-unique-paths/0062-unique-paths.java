class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return path(m,n,dp);
    }
    public int path(int m,int n,int[][] dp){
        if(m==0 || n==0)return 0;
        if(m==1 && n==1)return 1;
        if(dp[m][n]!=-1)return dp[m][n];
        return dp[m][n]=path(m,n-1,dp)+path(m-1,n,dp);
    }
}