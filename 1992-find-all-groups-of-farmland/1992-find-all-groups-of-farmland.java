class Solution {
    public int[][] findFarmland(int[][] land) {
        int m=land.length;
        int n=land[0].length;
        boolean vis[][]=new boolean[m][n];
        List<int[]> result=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==1 && !vis[i][j]){
                    int[] bottomRight=new int[]{i,j};
                    dfs(land,vis,m,n,i,j,bottomRight);
                    result.add(new int[]{i,j,bottomRight[0],bottomRight[1]});
                }
            }
        }
        return result.toArray(new int[0][]);
    }
    public static void dfs(int[][] land, boolean[][] vis, int m,int n,int row,int col,int[] bottomRight){
        vis[row][col]=true;
        bottomRight[0]=Math.max(bottomRight[0],row);
        bottomRight[1]=Math.max(bottomRight[1],col);
        if(row-1>=0 && land[row-1][col]==1 && !vis[row-1][col]){
            dfs(land,vis,m,n,row-1,col,bottomRight);
        }
        if(row+1<m && land[row+1][col]==1 && !vis[row+1][col]){
            dfs(land,vis,m,n,row+1,col,bottomRight);
        }
        if(col-1>=0 && land[row][col-1]==1 && !vis[row][col-1]){
            dfs(land,vis,m,n,row,col-1,bottomRight);
        }
        if(col+1<m && land[row][col+1]==1 && !vis[row][col+1]){
            dfs(land,vis,m,n,row,col+1,bottomRight);
        }
    }
}