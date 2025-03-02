class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int pSum=0;
        int count=0;
        for(int num:nums){
            pSum+=num;
            if(hm.containsKey(pSum-k)){
                count+=hm.get(pSum-k);
            }
            hm.put(pSum,hm.getOrDefault(pSum,0)+1);
        }
        return count;
    }
}