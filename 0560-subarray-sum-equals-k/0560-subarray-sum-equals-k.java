class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int prefix=0;
        int count=0;
        for(int num:nums){
            prefix +=num;
            if(hm.containsKey(prefix-k)){
                count+=hm.get(prefix-k);
            }
            hm.put(prefix,hm.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}