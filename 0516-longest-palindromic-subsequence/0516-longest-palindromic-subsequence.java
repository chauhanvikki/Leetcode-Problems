class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        int[][] dp=new int[s.length()+1][s2.length()+1];
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=s.length();j++){
                dp[i][j]=0;
            }
        }
        return lcs(s,s2,dp);
    }
    public int lcs(String s1,String s2,int[][] dp){
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s1.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}