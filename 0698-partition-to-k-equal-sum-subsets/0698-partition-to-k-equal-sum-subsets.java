class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int target=sum/k;
        if(sum%k!=0)return false;
        int[] subsets=new int[k];
        Arrays.sort(nums);

        return helper(nums,subsets,nums.length-1,target);
    }
    public boolean helper(int[] nums,int[] subsets,int idx,int target){
        if(idx==-1)return true;

        for(int i=0;i<subsets.length;i++){
            if(subsets[i]+nums[idx]>target)continue;
            subsets[i]+=nums[idx];
            if(helper(nums,subsets,idx-1,target)){
                return true;
            }
            subsets[i]-=nums[idx];
        }
        return false;
    }
}