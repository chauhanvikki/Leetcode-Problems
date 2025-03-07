class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int j=0;
        int n=nums.length;
        int[] res=new int[nums.length];
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                res[j]=nums[i];
                j++;
            }
            // j++;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                res[j]=nums[i];
                j++;
            }
            
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                res[j]=nums[i];
                j++;
            }
        }
        return res;
    }
}