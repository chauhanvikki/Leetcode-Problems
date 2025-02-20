class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int pre[]=new int[n];
        int suff[]=new int[n];
        pre[0]=nums[0];
        suff[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*nums[i];
        }
        // ans[0]=suff[0];
        for(int i=n-2;i>=0;i--){
            suff[i]=nums[i]*suff[i+1];
        }
        int ans[]=new int[n];
        ans[0]=suff[1];
        ans[n-1]=pre[n-2];
        for(int i=1;i<n-1;i++){
            ans[i]=pre[i-1]*suff[i+1];
        }
        return ans;
    }
}