class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        int freq[]=new int[2];
        dp[0]=0;
        for(int i=1;i<n+1;i++){
            if(s.charAt(i-1)=='a'){
                if(freq[1]>0){
                    dp[i]=Math.min(dp[i-1]+1,freq[1]);
                }
                else{
                    dp[i]=dp[i-1];
                }
                freq[0]++;
            }
            else{
                freq[1]++;
                dp[i]=dp[i-1];
            }
        }
        return dp[n];
    }
}