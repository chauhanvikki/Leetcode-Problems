class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(hm.containsKey(nums[i])){
                return new int[]{i,hm.get(nums[i])};
            }
            hm.put(sub,i);
        }
        return new int[]{};
    }
}