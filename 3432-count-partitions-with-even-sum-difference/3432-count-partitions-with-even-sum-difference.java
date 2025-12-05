class Solution {
    public int countPartitions(int[] nums) {
        int[] arr=new int[nums.length];
        arr[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            arr[i]=arr[i-1]+nums[i];
        }
        int ans=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if((arr[i]-(arr[j]-arr[i]))%2==0){
                ans++;
            }
            i++;
        }
        return ans;
    }
}