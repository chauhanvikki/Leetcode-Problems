class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }
            else{
                return nums[i];
            }
        }
        return -1;
    }
}