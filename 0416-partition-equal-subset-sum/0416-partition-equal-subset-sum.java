class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total%2==1)return false;
        int target=total/2;
        dp=new Boolean[nums.length][target+1];
        return helper(nums,0,target);
    }
    public boolean helper(int[] nums,int idx,int target){
        if(target==0)return true;
        if(idx==nums.length || target<0)return false;
        if(dp[idx][target]!=null)return dp[idx][target];
        boolean skip=helper(nums,idx+1,target);
        boolean take=helper(nums,idx+1,target-nums[idx]);
        dp[idx][target]= skip||take;
        return dp[idx][target];
    }
}
