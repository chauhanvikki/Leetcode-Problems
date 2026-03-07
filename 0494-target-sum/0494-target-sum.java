class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
    }
    public int helper(int nums[], int target,int ans,int i){
        if(i==nums.length && ans==target)return 1;
        else if(i==nums.length)return 0;
        int pos=helper(nums,target,ans+nums[i],i+1);
        int neg=helper(nums,target,ans-nums[i],i+1);
        return neg+pos;
    }
}
