class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLen=matrix.length-1;
        int colLen=matrix[0].length-1;
        int row=0,col=0;
        List<Integer> ls=new ArrayList<>();
        while(row<=rowLen && col<=colLen){
        for(int i=col;i<=colLen;i++){
            ls.add(matrix[row][i]);
        }
        for(int i=row+1;i<=rowLen;i++){
            ls.add(matrix[i][colLen]);
        }
        if(row<rowLen){
            for(int i=colLen-1;i>=col;i--){
                ls.add(matrix[rowLen][i]);
            }
        }
        if(col<colLen){
            for(int i=rowLen-1;i>row;i--){
                ls.add(matrix[i][col]);
            }
        }
        row++;
        col++;
        rowLen--;
        colLen--;
        }
        return ls;
    }    
}