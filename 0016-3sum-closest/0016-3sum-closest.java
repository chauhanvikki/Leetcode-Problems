class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(min>Math.abs(sum-target)){
                    min=Math.min(min,Math.abs(sum-target));
                    ans=sum;
                }
                if(target>sum){
                    j++;
                }
                if(target<sum){
                    k--;
                }
                else{
                    return sum;
                }
            }
        }
        return ans;
    }
}