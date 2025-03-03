class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int m=Integer.MAX_VALUE;
        // int i=
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                m=Math.min(Math.abs(hm.get(nums[i])-i),m);
            }
            hm.put(nums[i],i);
        }
        if(m<=k){
            return true;
        }
        return false;
    }
}