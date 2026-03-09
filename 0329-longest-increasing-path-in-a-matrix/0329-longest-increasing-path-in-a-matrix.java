class Solution {
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
        m=matrix.length;
        n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,helper(matrix,i,j,dp));
            }
        }
        return ans;
    }
    public int helper(int[][] matrix,int i,int j,int[][] dp){
        int ans=1;
        if(dp[i][j]!=0)return dp[i][j];
        if(i>0 && matrix[i][j]<matrix[i-1][j]){
            ans=Math.max(ans,1+helper(matrix,i-1,j,dp));
        }
        if(j>0 && matrix[i][j]<matrix[i][j-1]){
            ans=Math.max(ans,1+helper(matrix,i,j-1,dp));
        }
        if(i<m-1 && matrix[i][j]<matrix[i+1][j]){
            ans=Math.max(ans,1+helper(matrix,i+1,j,dp));
        }
        if(j<n-1 && matrix[i][j]<matrix[i][j+1]){
            ans=Math.max(ans,1+helper(matrix,i,j+1,dp));
        }
        return dp[i][j]=ans;
    }
}