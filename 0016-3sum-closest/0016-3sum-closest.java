// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//         // HashSet<List<Integer>> ls=new HashSet<>();
//         int n=nums.length;
//         int ans=0;
//         int min=Integer.MAX_VALUE;
//         Arrays.sort(nums);
//         for(int i=0;i<n-2;i++){
//             int j=i+1;
//             int k=n-1;
//             while(j<k){
//                 int sum=nums[i]+nums[j]+nums[k];
//                 if(Math.abs(target-sum)<min){
//                     ans=sum;
//                     min=Math.abs(sum-target);
//                 }
//                 if(target>sum){
//                     j++;
//                 }
//                 if(target<sum){
//                     k--;
//                 }
//                 else{
//                     return target;
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int minDiff=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<n-2;i++){
            int low=i+1,high=n-1;
            while(low<high){
                int temp=nums[i]+nums[low]+nums[high];
                if(Math.abs(target-temp)<minDiff){
                    ans=temp;
                    minDiff=Math.abs(target-temp);
                }
                if(temp==target){
                    return target;
                }
                else if(temp>target){
                        high--;
                }
                else{
                    low++;
                }
            }
        }
        return ans;
            
    }       
}