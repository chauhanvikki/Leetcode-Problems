class Solution {
    public boolean exist(char[][] board, String word) {
        char ch=word.charAt(0);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean vis[][]=new boolean[board.length][board[0].length];
                    if(helper(board,word,0,vis,i,j))return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board,String word,int index,boolean vis[][],int i,int j){
        if(index==word.length())return true;
        if(i>=board.length || j>=board[0].length || i<0 || j<0 || vis[i][j]){
            return false;
        }

        if(board[i][j]!=word.charAt(index))return false;

        vis[i][j]=true;

        boolean found=helper(board,word,index+1,vis,i-1,j) || helper(board,word,index+1,vis,i,j-1) || helper(board,word,index+1,vis,i+1,j) || helper(board,word,index+1,vis,i,j+1);

        vis[i][j]=false;
        return found;
    }
}