class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        if(nums.length<=1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=nums[2]+nums[0];
        for(int i=3;i<nums.length;i++){
            dp[i]=nums[i]+Math.max(dp[i-2],dp[i-3]);
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    //     Arrays.fill(dp,-1);
    //     int idx=0;
    //     return maxMoney(nums,dp,idx);
    // }
    // public int maxMoney(int[] nums,int[] dp,int idx){
    //     if(idx>=nums.length)return 0;
    //     if(dp[idx]!=-1)return dp[idx];
    //     int steal=nums[idx]+maxMoney(nums,dp,idx+2);
    //     int skip=maxMoney(nums,dp,idx+1);
    //     return dp[idx]=Math.max(steal,skip);
    }
}