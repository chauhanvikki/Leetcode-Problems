class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
                int result=Math.abs(nums[i]-nums[i+1]);
                if(max<result){
                    max=result;
                }
        }
        if(max<Math.abs(nums[nums.length-1]-nums[0])){
            max=Math.abs(nums[nums.length-1]-nums[0]);
        }
        return max;
    }
}