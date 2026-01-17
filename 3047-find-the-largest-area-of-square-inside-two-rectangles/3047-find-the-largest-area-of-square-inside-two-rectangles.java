class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n=bottomLeft.length;
        long maxArea=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int left=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int right=Math.min(topRight[i][0],topRight[j][0]);
                int top=Math.min(topRight[i][1],topRight[j][1]);
                int bottom=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                if(top>bottom && left<right){
                    int mini=Math.min(top-bottom,right-left);
                    maxArea=Math.max(1L*mini*mini,maxArea);
                }
            }
        }
        return maxArea;
    }
}