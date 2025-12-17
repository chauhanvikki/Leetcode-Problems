class Solution {
    long neg=Long.MIN_VALUE/4;
    long t[][][];
    public long maximumProfit(int[] prices, int k) {
        int n=prices.length;
        t=new long[n][k+1][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=k;j++){
                for(int l=0;l<3;l++){
                    t[i][j][l]=neg;
                }
            }
        }
        return solve(0,k,0,prices);
    }
    public long solve(int i,int k,int state,int[] prices){
        if(i>=prices.length){
            if(state==0)return 0;
            return neg;
        }
        if(t[i][k][state]!=neg){
            return t[i][k][state];
        }
        long take=neg;
        long dontTake;

        dontTake=solve(i+1,k,state,prices);
        if (state == 0) {
            take = Math.max(
                    -prices[i] + solve(i + 1, k, 1, prices),
                     prices[i] + solve(i + 1, k, 2, prices)
            );
        }
        if(k>0){
            if(state==1){
                take=prices[i]+solve(i+1,k-1,0,prices);
            }
            else if(state==2){
                take=-prices[i]+solve(i+1,k-1,0,prices);
            }
        }
        return t[i][k][state]=Math.max(take,dontTake);
    }
}