class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int j=0;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                sum-=nums[j];
                mini=Math.min(mini,i-j+1);
                j++;
            }
        }
        if(mini==Integer.MAX_VALUE)return 0;
        return mini;
    }
}