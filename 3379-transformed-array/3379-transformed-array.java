class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int index=0;
        for(int i=0;i<n;i++){
            int a=nums[i]%n;
            int newIndex=a+i;
            if(newIndex<0){
                newIndex+=n;
            }
            else if(newIndex>=n){
                newIndex-=n;
            }
            result[i]=nums[newIndex];
        }
        return result;
    }
}