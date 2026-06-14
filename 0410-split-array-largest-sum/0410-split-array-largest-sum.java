class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int split=func(mid,nums);
            if(split<k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int func(int mid,int[] nums){
        int split=0;
        int sum=0;
        for(int num:nums){
            sum+=num;
            if(sum>mid){
                split+=1;
                sum=num;
            }
        }
        return split;
    }
}