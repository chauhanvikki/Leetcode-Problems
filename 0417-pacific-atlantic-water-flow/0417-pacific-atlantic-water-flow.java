class Solution {
    int[][] heights;
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        m=heights.length;
        n=heights[0].length;
        boolean pacific[][]=new boolean[m][n];
        boolean atlantic[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i,0,pacific);
            dfs(i,n-1,atlantic);
        }
        for(int i=0;i<n;i++){
            dfs(0,i,pacific);
            dfs(m-1,i,atlantic);
        }

        List<List<Integer>> ls=new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ls.add(Arrays.asList(i,j));
                }
            }
        }
        return ls;
    }
    public void dfs(int row,int col,boolean[][] oceans){
        if(oceans[row][col])return;
        oceans[row][col]=true;
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d: dir){
            int nr=d[0]+row;
            int nc=d[1]+col;

            if(nr<0 || nc<0 || nr>=m || nc>=n)continue;

            if(heights[row][col]<=heights[nr][nc]){
                dfs(nr,nc,oceans);
            }
        }
    }
}