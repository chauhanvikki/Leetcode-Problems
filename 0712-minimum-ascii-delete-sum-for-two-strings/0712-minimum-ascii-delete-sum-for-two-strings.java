class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int total=0;
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            total+=(int)s1.charAt(i);
        }
        for(int i=0;i<n;i++){
            total+=(int)s2.charAt(i);
        }
        return helper(s1,s2,total,dp);
    }
    public int helper(String s1,String s2, int total,int[][] dp){
        int m=s1.length();
        int n=s2.length();
        int sum=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+(int)s1.charAt(i-1);
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return total-2*dp[m][n];
    }
}