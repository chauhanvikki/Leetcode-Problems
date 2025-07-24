class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean unDefeat[]=new boolean[n];
        Arrays.fill(unDefeat,true);
        for(int edge[]:edges){
            int winner=edge[0];
            int loser=edge[1];
            unDefeat[loser]=false;
        }

        int champCount=0;
        int champion=-1;
        for(int i=0;i<n;i++){
            if(unDefeat[i]==true){
                champCount++;
                champion=i;
            }
        }
        if(champCount==1)return champion;
        return -1;
    }
}