class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ne=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
            ne[i]=nums[i];
        }
        Arrays.sort(ne);
        return ne;
    }
}