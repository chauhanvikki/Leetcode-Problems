class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // int cand=nums[0];
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     if(count==0){
        //         cand=nums[i];
        //     }
        //     if(nums[i]==cand){
        //         count++;
        //     }
        //     else{
        //         count--;
        //     }
        // }
        // count=0;
        // List<Integer> l=new ArrayList<>();
        // for(int i:nums){
        //     if(i==cand){
        //         count++;
        //     }
        // }
        // if(count<nums.length/3){
        //     l.add(cand);
        // }
        // return l;
        List<Integer> l=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int check=nums.length/3;
        for(int i: hm.keySet()){
            if(hm.get(i)>check){
                l.add(i);
            }
        }
        return l;
    }
}