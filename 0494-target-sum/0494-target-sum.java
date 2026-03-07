class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp=new Integer[nums.length][2001];
        return helper(nums,target,0,0);
    }
    public int helper(int nums[], int target,int ans,int i){
        if(i==nums.length && ans==target)return 1;
        else if(i==nums.length)return 0;
        if(dp[i][ans+1000]!=null)return dp[i][ans+1000];
        int pos=helper(nums,target,ans+nums[i],i+1);
        int neg=helper(nums,target,ans-nums[i],i+1);
        return dp[i][ans+1000]=neg+pos;
    }
}
