class Solution {
    public boolean safe(char[][] board,int row,int col,int n){
 
        // Vertical diagonal
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row-1, j=col+1; i>=0 && j<n; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public void nQueens(char[][] board, int row, int n, List<List<String>> ans){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int j=0;j<n;j++){
            if(safe(board,row,j,n)){
                board[row][j]='Q';
                nQueens(board,row+1,n,ans);
                board[row][j]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
         for (char[] row : board) Arrays.fill(row, '.');
        nQueens(board,0,n,ans);
        return ans;
    }
}