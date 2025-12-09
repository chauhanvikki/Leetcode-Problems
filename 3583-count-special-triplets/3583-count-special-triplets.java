class Solution {
    public int specialTriplets(int[] nums) {
        int mod=1000000007;
        HashMap<Integer,Integer> left=new HashMap<>();
        HashMap<Integer,Integer> right=new HashMap<>();
        long count=0;
        for(int i=2;i<nums.length;i++){
            right.put(nums[i],right.getOrDefault(nums[i],0)+1);
        }
        int i=1;
        left.put(nums[0],1);
        while(i<nums.length-1){
            int req=nums[i]*2;
            if(left.containsKey(req) && right.containsKey(req)){
                int n1=left.get(req);
                int n2=right.get(req);
                count=(count+((long)n1*(long)n2)%mod)%mod;
            }
            left.put(nums[i],left.getOrDefault(nums[i],0)+1);
            if(i+1<nums.length){
                right.put(nums[i+1],right.get(nums[i+1])-1);
                if(right.get(nums[i+1])==0){
                    right.remove(nums[i+1]);
                }
            }
            i++;
        }
        return (int)count;
    }
}