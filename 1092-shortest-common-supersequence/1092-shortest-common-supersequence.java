class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int[][] dp=new int[m+1][n+1];
        return scs(str1,str2,dp);
    }
    public String scs(String str1,String str2, int[][] dp){
        int m=str1.length();
        int n=str2.length();
        String ans="";
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=m;
        int j=n;
        while(i!=0 && j!=0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans+=str1.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    ans+=str1.charAt(i-1);
                    i--;
                }
                else{
                    ans+=str2.charAt(j-1);
                    j--;
                }
            }
        }
        while(i>0){
            ans+=str1.charAt(i-1);
            i--;
        }
        while(j>0){
            ans+=str2.charAt(j-1);
            j--;
        }
        return new StringBuilder(ans).reverse().toString();
    }
}