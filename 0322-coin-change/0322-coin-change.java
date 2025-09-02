class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-2);
        dp[0]=0;
        return coin(coins,amount,dp);
    }
    public int coin(int[] coins,int amt,int[] dp){
        if(amt<0){
            return -1;
        }
        if(amt==0)return 0;
        if(dp[amt]!=-2)return dp[amt];

        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res=coin(coins,amt-coins[i],dp);
            if(res!=-1){
                min=Math.min(min,res+1);
            }
        }
        return dp[amt]=(min==Integer.MAX_VALUE)?-1:min;
    }
}