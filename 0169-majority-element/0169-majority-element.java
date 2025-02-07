class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int count=1;
        int output=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
                else{
                    break;
                }
            }
            if(ans<count){
                output=nums[i];
            }
            ans=Math.max(ans,count);
            count=1;
        }
        if(nums.length/2<ans){
            return output;
        }
        return -1;
    }
}