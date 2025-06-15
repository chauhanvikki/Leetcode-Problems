class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxi=0;
        while(i<j){
            if(height[i]<height[j]){
                maxi=Math.max(height[i]*(j-i),maxi);
                i++;
            }
            else{
                maxi=Math.max(height[j]*(j-i),maxi);
                j--;
            }
        }
        return maxi;
    }
}