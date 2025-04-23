class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(hm.containsKey(sub)){
                arr[0]=hm.get(sub);
                arr[1]=i;
            }
            hm.put(nums[i],i);
        }
        return arr;
    }
}