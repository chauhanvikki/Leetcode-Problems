class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        boolean[][] vis=new boolean[n][n];
        vis[n-1][0]=true;
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(curr==n*n){
                    return steps;
                }
                for(int k=1;k<=6;k++){
                    if(curr+k>n*n)break;
                    int[] pos=getPos(n,curr+k);
                    int r=pos[0];
                    int c=pos[1];
                    if(vis[r][c]==true)continue;
                    vis[r][c]=true;
                    if(board[r][c]==-1){
                        q.add(curr+k);
                    } 
                    else{
                        q.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private int[] getPos(int n,int curr){
        int r=n- (curr-1)/n -1;
        int c=(curr-1)%n;
        if(r%2==n%2){
            return new int[]{r,n-c-1};
        }
        return new int[]{r,c};
    }
}