class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] left=new int[n];
        left[0]=height[0];
        for(int i=1;i<n;i++){
            int lm=Math.max(left[i-1],height[i]);
            left[i]=lm;
        }
        int[] right=new int[n];
        right[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            int rm=Math.max(right[i+1],height[i]);
            right[i]=rm;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            int trap=Math.min(left[i],right[i]) - height[i];
            sum+=trap;
        }
        return sum;
    }
}