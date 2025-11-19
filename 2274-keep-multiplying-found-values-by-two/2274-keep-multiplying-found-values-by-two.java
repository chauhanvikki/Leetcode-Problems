class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        return helper(hs,original);
    }
    public int helper(HashSet<Integer> hs,int original){
        if(!hs.contains(original)){
            return original;
        }
        return helper(hs,original*2);
    }
}