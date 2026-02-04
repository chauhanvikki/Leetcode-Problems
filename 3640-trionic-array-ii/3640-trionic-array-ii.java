// class Solution {
//     int n;
//     public long maxSumTrionic(int[] nums) {
//         n=nums.length;
//         long[][] dp=new long[n][4];
//         for(int i=0;i<n+1;i++){
//             for(int j=1;j<4;j++){
//                 dp[i][j]=Long.MIN_VALUE;
//             }
//         }
//         return solve(0,0,nums,dp);
//     }
//     public long solve(int i,int trend,int[] nums,long[][] dp){
//         if(i==n){
//             if(trend==3)return 0;
//             else{
//                 return Long.MIN_VALUE/2;
//             }
//         }
//         if(dp[i][trend]!=Long.MIN_VALUE){
//             return dp[i][trend];
//         }
//         Long take=Long.MIN_VALUE/2;
//         Long skip=Long.MIN_VALUE/2;
//         int curr=nums[i];
//         int next=nums[i+1];
//         if(trend==0)skip=solve(i+1,0,nums,dp);
//         else if(trend==1){
//             if(next>curr){
//                 take=Math.max(take,curr+solve(i+1,1,nums,dp));
//             }
//             else if(next<curr){
//                 take=Math.max(take,curr+solve(i+1,2,nums,dp));
//             }
//         }
//         else if(trend==2){
//             if(next<curr){
//                 take=Math.max(take,curr+solve(i+1,2,nums,dp));
//             }
//             else if(next>curr){
//                 take=Math.max(take,curr+solve(i+1,3,nums,dp));
//             }
//         }
//         return dp[i][trend]=Math.max(take,skip);
//     }
// }
// class Solution {
//     long NEG = -100000000000000L;
//     long dp[][];
//     long f(int index, int status, int n, int[] nums) {
//         if (index == n) {
//             return status == 3 ? 0 : NEG;
//         }
//         if(dp[index][status]!=Long.MIN_VALUE){
//             return dp[index][status];
//         }
//         long take = NEG;
//         long notTake = NEG;

//         if (status == 0) {
//             notTake = f(index + 1, 0, n, nums);
//         }

//         if (status == 3) {
//             take = nums[index];
//         }
//         if (index + 1 < n) {
//             if (status == 0 && nums[index + 1] > nums[index]) {
//                 take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
//             } 
//             else if (status == 1) {
//                 if (nums[index + 1] > nums[index]) {
//                     take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
//                 } else if (nums[index + 1] < nums[index]) {
//                     take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
//                 }
//             } 
//             else if (status == 2) {
//                 if (nums[index + 1] < nums[index]) {
//                     take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
//                 } else if (nums[index + 1] > nums[index]) {
//                     take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
//                 }
//             } 
//             else if (status == 3 && nums[index + 1] > nums[index]) {
//                 take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
//             }
//         }

//         return dp[index][status]=Math.max(take, notTake);
//     }

//     public long maxSumTrionic(int[] nums) {
//         dp=new long[nums.length][4];
//         for(int i=0;i<nums.length;i++){
//             for(int j=1;j<4;j++){
//                 dp[i][j]=Long.MIN_VALUE;
//             }
//         }
//         return f(0, 0, nums.length, nums);
//     }
// }

class Solution {
    long NEG = -100000000000000L;
    Long[][] dp;

    long f(int index, int status, int n, int[] nums) {
        if (index == n) {
            return status == 3 ? 0 : NEG;
        }

        if (dp[index][status] != null) return dp[index][status];

        long take = NEG;
        long notTake = NEG;

        if (status == 0) {
            notTake = f(index + 1, 0, n, nums);
        }

        if (status == 3) {
            take = nums[index];
        }

        if (index + 1 < n) {
            if (status == 0 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
            } 
            else if (status == 1) {
                if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
                } else if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
                }
            } 
            else if (status == 2) {
                if (nums[index + 1] < nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
                } else if (nums[index + 1] > nums[index]) {
                    take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
                }
            } 
            else if (status == 3 && nums[index + 1] > nums[index]) {
                take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
            }
        }

        return dp[index][status] = Math.max(take, notTake);
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        dp = new Long[n][4];
        return f(0, 0, n, nums);
    }
}