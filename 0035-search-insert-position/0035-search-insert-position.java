class Solution {
    public int searchInsert(int[] nums, int target) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                // System.out.print(i);
                // return i;
                j=i;
                break;
            }
            else{
                j=i+1;
            }
        }
        return j;
    }
}