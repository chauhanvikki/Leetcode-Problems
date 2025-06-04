class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int total=0;
        int n=status.length;
        boolean vis[]=new boolean[n];
        for(int v:initialBoxes){
            dfs(v,status,keys,containedBoxes,vis);
        }
        for(int i=0;i<n;i++){
            if(vis[i] && status[i]==1){
                total+=candies[i];
            }
        }
        return total;
    }
    private void dfs(int v,int[] status,int[][] keys,int [][] containedBoxes, boolean vis[]){
        vis[v]=true;
        for(int vKey : keys[v]){
            if(vKey==v){
                continue;
            }
            status[vKey]=1;
        }

        for(int contain : containedBoxes[v]){
            if(!vis[contain]){
                dfs(contain,status,keys,containedBoxes,vis);
            }
        }
        return;
    }
}