class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1=Integer.MIN_VALUE;
        int cand2=Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==cand1){
                count1++;
            }
            else if(nums[i]==cand2){
                count2++;
            }
            else if(count1==0){
                cand1=nums[i];
                count1=1;
            }
            else if(count2==0){
                cand2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        List<Integer> l=new ArrayList<>();
        for(int i:nums){
            if(i==cand1){
                count1++;
            }
            if(i==cand2){
                count2++;
            }
        }
        if(count1>nums.length/3 ){
            l.add(cand1);
        }
        if(count2>nums.length/3 && cand1!=cand2){
            l.add(cand2);
        }
        return l;
        // List<Integer> l=new ArrayList<>();
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i:nums){
        //     hm.put(i,hm.getOrDefault(i,0)+1);
        // }
        // int check=nums.length/3;
        // for(int i: hm.keySet()){
        //     if(hm.get(i)>check){
        //         l.add(i);
        //     }
        // }
        // return l;
    }
}