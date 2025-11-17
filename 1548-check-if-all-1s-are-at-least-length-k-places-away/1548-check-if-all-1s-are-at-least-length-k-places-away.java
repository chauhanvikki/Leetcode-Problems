class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int gap=0;
        int index1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                index1=i;
                break;
            }
        }
        for(int i=index1+1;i<nums.length;i++){
            if(nums[i]==1){
                if(gap<k)return false;
                else{
                    gap=0;
                }
            }
            else{
                gap++;
            }
        }
        return true;
    }
}