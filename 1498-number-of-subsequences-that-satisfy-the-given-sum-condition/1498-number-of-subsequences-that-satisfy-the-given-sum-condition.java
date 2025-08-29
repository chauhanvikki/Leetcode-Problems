class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        int count=0;
        while(l<=r){
            if(nums[l]+nums[r]<=target){
                count+=Math.pow(2,(r-l));
                l++;
            }
            else{
                r--;
            }
        }
        return count;
    }
}