class Solution {
    public int majorityElement(int[] nums) {
        int candi=nums[0];
        int count=0;
        for(int num:nums){
            if(count==0){
                candi=num;
            }
            if(candi==num){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for(int num:nums){
            if(candi==num){
                count++;
            }
        }
        if(count>nums.length/2){
            return candi;
        }
        return -1;
    }
}