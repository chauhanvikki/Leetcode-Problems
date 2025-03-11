class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(hm.containsKey(sub)){
                return new int[]{hm.get(sub),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }
}