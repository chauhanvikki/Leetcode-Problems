class Solution {
    public int missingNumber(int[] nums) {
        // HashSet<Integer> hs=new HashSet<>();
        // for(int num:nums){
        //     hs.add(num);
        // }
        // for(int i=0;i<nums.length;i++){
        //     if(!hs.contains(i)){
        //         return i;
        //     }
        //     hs.remove(i);
        // }
        // return nums.length;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=i^nums[i];
        }
        return xor^nums.length;
    }
}
