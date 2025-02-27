class Solution {
    public int pivotIndex(int[] nums) {
        int p[]=new int[nums.length];
        p[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            p[i]=nums[i]+p[i-1];
        }
        int l=p[nums.length-1];
        int j=0;
        while(j<nums.length){
            int left;
            left=(j==0)?0:p[j-1];  //using the ternary operator (? :)
            int total=p[nums.length-1];
            int right=total-p[j];
            if(left==right){
                return j;
            }
            j++;
        }
        return -1;
    }
}