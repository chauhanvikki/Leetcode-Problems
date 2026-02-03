class Solution {
    public boolean isTrionic(int[] nums) {
        int i=0;
        if(nums.length<4)return false;
        if(nums[i]>nums[i+1]){
            return false;
        }
        if(nums[i]<nums[i+1]){
            while(i<nums.length-1 && nums[i]<nums[i+1]){
                i++;
            }
        }
        if(i==nums.length-1){
            return false;
        }
        while(i<nums.length-1 && nums[i]>nums[i+1]){
            i++;
        }
        if(i==nums.length-1){
            return false;
        }
        while(i<nums.length-1 && nums[i]<nums[i+1]){
            i++;
        }
        if(i==nums.length-1){
            return true;
        }
        return false;
    }
}