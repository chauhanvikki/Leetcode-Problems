class Solution {
    public int maxSubArray(int[] nums) {
        // int[][] dp=new int[nums.length][nums.length];
        // int ans=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     dp[i][i]=nums[i];
        //     ans=Math.max(ans,dp[i][i]);
        //     for(int j=i+1;j<nums.length;j++){
        //         dp[i][j]=dp[i][j-1]+nums[j];
        //         ans=Math.max(ans,dp[i][j]);
        //     }
        // }
        // return ans;
        int ans=nums[0];
        int curr=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=Math.max(nums[i],curr+nums[i]);
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}
