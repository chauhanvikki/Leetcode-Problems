class Solution {
    public long distributeCandies(int n, int limit) {
        // long count=0;
        // for(int a=0;a<=Math.min(n,limit);a++){
        //     int b1=Math.max(0,n-a-limit);
        //     int b2=Math.min(limit,n-a);
        //     if(b1<=b2){
        //         count+=(long)(b2-b1+1);
        //     }
        // }
        // return count;
        long ans=0;
        for(int i=0;i<=Math.min(n,limit);i++){
            int remaining=n-i;
            int maxi=Math.min(remaining,limit);
            remaining=remaining-maxi;
            ans+=Math.max(maxi-remaining+1,0);
        }
        return ans;
    }
}