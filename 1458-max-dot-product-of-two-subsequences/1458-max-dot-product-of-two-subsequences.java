class Solution {
    Integer dp[][];
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        dp=new Integer[n][m];
        return solve(nums1,nums2,0,0);
    }
    public int solve(int[] nums1,int[] nums2,int i,int j){
        if(i==nums1.length || j==nums2.length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]!=null)return dp[i][j];
        int product=nums1[i]*nums2[j];
        int include=product+Math.max(0,solve(nums1,nums2,i+1,j+1));
        int exclude1=solve(nums1,nums2,i+1,j);
        int exclude2=solve(nums1,nums2,i,j+1);
        return dp[i][j]=Math.max(include,Math.max(exclude1,exclude2));
    }
}