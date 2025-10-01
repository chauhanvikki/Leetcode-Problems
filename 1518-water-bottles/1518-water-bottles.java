class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n=numBottles;
        int ans=numBottles;
        while(n!=0){
            ans+=n/numExchange;
            if(n>=numExchange){
                n=(n/numExchange)+n%numExchange;
            }else{
                n=0;
            }
        }
        return ans;       
    }
}