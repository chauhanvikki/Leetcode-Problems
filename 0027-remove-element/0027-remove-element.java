class Solution {
    public int removeElement(int[] nums, int val) {
        // Arrays.sort(nums);
        // int k=0;
        // List<Integer> ls=new ArrayList<>();
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=val){
        //         nums[k]=nums[i];
        //         k++;
        //     }
        // }
        // return k;
        int count=nums.length;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                count--;
                continue;
            }else{
                nums[j]=nums[i];
                j++;
            }
        }
        return count;
    }
}