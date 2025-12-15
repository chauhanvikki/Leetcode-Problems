class Solution {
    public long getDescentPeriods(int[] prices) {
        long len=1;
        long count=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-prices[i]==1){
                len++;
            }
            else{
                count+=len*(len+1)/2;
                len=1;
            }
        }
        count+=len*(len+1)/2;
        return count;
    }
}