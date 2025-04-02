class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j){
            if(height[i]>=height[j]){
                max=Math.max(height[j]*(j-i),max);
                j--;
            }
            else{
                max=Math.max(height[i]*(j-i),max);
                i++;
            }
        }
        return max;
    }
}