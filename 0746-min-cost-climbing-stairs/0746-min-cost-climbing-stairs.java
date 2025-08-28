class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    //     Arrays.fill(dp1,-1);
    //     int case1=minCost(cost,dp1,0);
    //     int case2=minCost(cost,dp1,1);
    //     return Math.min(case1,case2);
    // }
    // public int minCost(int[] cost,int[] dp,int idx){
    //     if(idx>=cost.length)return 0;
    //     if(dp[idx]!=-1)return dp[idx];
    //     int jump=cost[idx]+minCost(cost,dp,idx+1);
    //     int skip=cost[idx]+minCost(cost,dp,idx+2);
    //     return dp[idx]=Math.min(jump,skip);
    }
}