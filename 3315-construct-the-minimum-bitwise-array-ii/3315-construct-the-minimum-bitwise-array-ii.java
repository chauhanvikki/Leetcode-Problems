class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[]=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            int n = nums.get(i);
            if (n  == 2) {
                ans[i] = -1; 
            } else {
                int mark=~(((n+1) & ~n)>>1);
                ans[i]=n & mark; 
            }
        }
        return ans;
    }
}