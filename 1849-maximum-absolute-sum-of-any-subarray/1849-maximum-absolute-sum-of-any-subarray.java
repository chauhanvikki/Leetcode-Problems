class Solution {
    public int maxAbsoluteSum(int[] nums) {
       int sum=0;
       int ms=0;
       int mi=0;
       for(int num:nums){
        sum+=num;
        ms=Math.max(sum,ms);
        mi=Math.min(mi,sum);
       }
       return Math.abs(mi-ms);
    }
}