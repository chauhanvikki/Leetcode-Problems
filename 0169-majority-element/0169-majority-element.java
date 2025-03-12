class Solution {
    public int majorityElement(int[] nums) {
        // int candi=nums[0];
        // int count=0;
        // for(int num:nums){
        //     if(count==0){
        //         candi=num;
        //     }
        //     if(candi==num){
        //         count++;
        //     }
        //     else{
        //         count--;
        //     }
        // }
        // count=0;
        // for(int num:nums){
        //     if(candi==num){
        //         count++;
        //     }
        // }
        // if(count>nums.length/2){
        //     return candi;
        // }
        // return -1;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
                hm.put(i,hm.getOrDefault(i,0)+1);
            if(hm.get(i)>nums.length/2){
                return i;
            }
        }
        return -1;
    }
}