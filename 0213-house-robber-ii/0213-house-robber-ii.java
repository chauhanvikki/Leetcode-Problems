class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int idx=0;
        int case1=helper(nums,dp1,0,nums.length-2);
        int case2=helper(nums,dp2,1,nums.length-1);
        return Math.max(case1,case2);
    }
    public int helper(int[] nums, int[] dp,int idx,int end){
        if(idx>end)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int steal=nums[idx]+helper(nums,dp,idx+2,end);
        int skip=helper(nums,dp,idx+1,end);
        return dp[idx]=Math.max(skip,steal);
    }
}