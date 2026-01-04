class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] save=new boolean[m][n];
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(board[i][j]=='O'){
                        dfs(board,m,n,save,visited,i,j);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !save[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(char[][] board,int m,int n,boolean[][] save,boolean[][] visited,int i,int j){
        if( i<0 || j<0 || i>=m || j>=n || visited[i][j] || board[i][j]=='X'){
            return;
        }
        visited[i][j]=true;
        save[i][j]=true;
        dfs(board,m,n,save,visited,i-1,j);
        dfs(board,m,n,save,visited,i,j-1);
        dfs(board,m,n,save,visited,i+1,j);
        dfs(board,m,n,save,visited,i,j+1);
    }
}