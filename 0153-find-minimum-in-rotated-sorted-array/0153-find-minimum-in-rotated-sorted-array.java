class Solution {
    public int findMin(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums,int left,int right){
        int mid=left+(right-left)/2;
        if(left==right)return nums[mid];
        if(nums[mid]>nums[right]){
            return helper(nums,mid+1,right);
        }
        else {
            return helper(nums,left,mid);
        }
    }
}