class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            
        }
        int maxi=0;
        for(int key:hm.keySet()){
            if(hm.containsKey(key+1)){
                maxi=Math.max((hm.get(key)+hm.get(key+1)),maxi);
            }
        }
        return maxi;
    }
}