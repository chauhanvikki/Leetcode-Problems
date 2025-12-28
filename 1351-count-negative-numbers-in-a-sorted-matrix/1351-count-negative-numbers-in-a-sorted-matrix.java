class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            int firstNeg=col;
            int left=0,right=col-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(grid[i][mid]<0){
                    right=mid-1;
                    firstNeg=mid;
                }
                else{
                    left=mid+1;
                }
            }
            count+=col-firstNeg;
        }
        return count;
    }
}