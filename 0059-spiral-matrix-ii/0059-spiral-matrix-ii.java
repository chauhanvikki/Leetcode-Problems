class Solution {
    public int[][] generateMatrix(int n) {
        int left=0;
        int right=n-1;
        int top=0;
        int bottom=n-1;
        int val=1;
        int[][] matrix=new int[n][n];
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                matrix[top][i]=val;
                val++;
            }
            top++;
            for(int i=top; i<=bottom;i++){
                matrix[i][right]=val;
                val++;
            }
            right--;

            if(bottom>=top){
                for(int i=right;i>=left;i--){
                    matrix[bottom][i]=val;
                    val++;
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left]=val;
                    val++;
                }
                left++;
            }
        }
        return matrix;
    }
}