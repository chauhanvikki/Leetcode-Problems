class Solution {
    public int minimumCost(int[] nums) {
        int a=nums[0];
        int arr[]=new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            arr[i-1]=nums[i];
        }
        Arrays.sort(arr);
        return a+arr[0]+arr[1];
    }
}