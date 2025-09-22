class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix,target,0,0,0,matrix[0].length-1);
    }
    public boolean helper(int[][] matrix,int target,int row,int col,int left,int right){
        if (row >= matrix.length) return false;  
        if (left > right) return false;   
        int mid = left + (right - left) / 2;

        if (matrix[row][mid] == target) {
            return true;
        }

        if(left<=right && row<matrix.length && col<matrix[0].length){
            if(matrix[row][right]<target){
                return helper(matrix,target,row+1,0,0,matrix[0].length - 1);
            }
            else if(matrix[row][left]<=target && matrix[row][right]>=target){
                if(matrix[row][mid]<target){
                    return helper(matrix,target,row,mid+1,mid+1,right);
                }
                else{
                    return helper(matrix,target,row,0,left,mid-1);
                }
            }
        }
        return false;
    }
}