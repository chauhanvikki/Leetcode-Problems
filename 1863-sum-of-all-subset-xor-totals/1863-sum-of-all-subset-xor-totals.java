class Solution {
    public int subsetXORSum(int[] nums) {
        int ans=0;
        return xor(nums,ans,0);
    }
    public int xor(int[] nums,int ans,int index){
        if(index==nums.length){
            return ans;
        }
        int take=xor(nums,ans^nums[index],index+1);
        int notTake=xor(nums,ans,index+1);
        ans=take+notTake;
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna