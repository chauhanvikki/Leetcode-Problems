class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        int res=0;
        for(int i=0;i<n;i++){
            int[] bomb=bombs[i];
            boolean vis[]=new boolean[n];
            vis[i]=true;
            res=Math.max(res,dfs(bombs,vis,i,1));
        }
        return res;
    }
    public static int dfs(int[][] bombs,boolean vis[],int idx,int detonate){
        int[] currBomb=bombs[idx];
        for(int i=0;i<bombs.length;i++){
            if(vis[i] || idx==i)continue;
            int bomb[]=bombs[i];
            int x1=currBomb[0];
            int y1=currBomb[1];
            int r1=currBomb[2];

            int x2=bomb[0];
            int y2=bomb[1];
            int r2=bomb[2];

            long dx=(x1-x2);
            long dy=(y1-y2);

            long dr=((long)r1*(long)r1);
            if(dr>=(dx*dx)+(dy*dy)){
                vis[i]=true;
                detonate+=dfs(bombs,vis,i,1);
            }
        }
        return detonate;
    }
}