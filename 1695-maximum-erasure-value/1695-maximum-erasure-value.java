class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int maxi=0;
        int sum=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(hs.contains(nums[i])){
                int a=nums[j];
                hs.remove(nums[j]);
                sum-=a;
                j++;
            }
            hs.add(nums[i]);
            sum+=nums[i];
            maxi=Math.max(maxi,sum);
        }
        return maxi;
    }
}