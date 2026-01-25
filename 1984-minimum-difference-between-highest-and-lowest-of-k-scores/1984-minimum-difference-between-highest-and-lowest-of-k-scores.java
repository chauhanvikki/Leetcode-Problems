class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(nums.length==1)return 0;
        int ans=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-k;i++){
            ans=Math.min(ans,nums[k+i-1]-nums[i]);
        }
        return ans;
    }
}