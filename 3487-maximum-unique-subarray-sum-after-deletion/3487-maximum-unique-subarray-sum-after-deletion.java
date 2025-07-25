class Solution {
    public int maxSum(int[] nums) {
        int sum=0;
        boolean value=true;
        int maxi=Integer.MIN_VALUE;
        for(int n:nums){
            if(maxi<n)maxi=n;
            if(n>0){
                value=false;
            }
        }
        if(value)return maxi;
        HashSet<Integer> hs=new HashSet<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i]) && nums[i]>0){
                sum+=nums[i];
                hs.add(nums[i]);
            }
            maxi=Math.max(maxi,sum);
        }
        return maxi;
    }
}