class Solution {
    public String triangleType(int[] nums) {
        String s="equilateral";
        String s1="scalene";
        String s2="isosceles";
        if(nums[0]+nums[1]<=nums[2] ||nums[0]+nums[2]<=nums[1] || nums[2]+nums[1]<=nums[0] ){
            return "none";
        }
        if(nums[0]==nums[1] && nums[1]==nums[2]){
            return s;
        }
        if(nums[0]!=nums[1] && nums[1]!=nums[2] && nums[0]!=nums[2]){
            return s1;
        }
        return s2;
    }
}