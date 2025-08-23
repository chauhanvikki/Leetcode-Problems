class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int idx=0;
        return maxMoney(nums,dp,idx);
    }
    public int maxMoney(int[] nums,int[] dp,int idx){
        if(idx>=nums.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int steal=nums[idx]+maxMoney(nums,dp,idx+2);
        int skip=maxMoney(nums,dp,idx+1);
        return dp[idx]=Math.max(steal,skip);
    }
}