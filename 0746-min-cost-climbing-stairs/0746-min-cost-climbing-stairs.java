class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        // int[] dp2=new int[n];
        // Arrays.fill(dp2,-1);
        int case1=minCost(cost,dp1,0);
        int case2=minCost(cost,dp1,1);
        return Math.min(case1,case2);
        // return case1;
    }
    public int minCost(int[] cost,int[] dp,int idx){
        if(idx>=cost.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int jump=cost[idx]+minCost(cost,dp,idx+1);
        int skip=cost[idx]+minCost(cost,dp,idx+2);
        return dp[idx]=Math.min(jump,skip);
    }
}