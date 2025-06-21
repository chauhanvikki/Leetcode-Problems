class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] pSum=new int[nums.length];
        HashMap<Integer,Integer> hm=new HashMap<>();
        pSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pSum[i]=pSum[i-1]+nums[i];
        }
        hm.put(0,-1);
        for(int i=0;i<pSum.length;i++){
            int r=pSum[i]%k;
            if(hm.containsKey(r)){
                if(i-hm.get(r)>1){
                    return true;
                }
            }
            else{
                hm.put(r,i);
            }
        }
        return false;
    }
}