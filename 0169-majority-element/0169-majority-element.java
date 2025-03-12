class Solution {
    public int majorityElement(int[] nums) {
        int cand=nums[0];
        int count=0;
        for(int i:nums){
            if(count==0){
                cand=i;
            }
            if(cand==i){
                count++;
            }

            else{
                count--;
            }
        }
        count=0;
        for(int i:nums){
            if(cand==i){
                count++;
            }
        }
        if(count>nums.length/2){
            return cand;
        }
        return -1;
    //     HashMap<Integer,Integer> hm=new HashMap<>();
    //     for(int i:nums){
    //             hm.put(i,hm.getOrDefault(i,0)+1);
    //         if(hm.get(i)>nums.length/2){
    //             return i;
    //         }
    //     }
    //     return -1;
    }
}