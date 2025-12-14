class Solution {
    public int numberOfWays(String s) {
        int count=0;
        long totalWays=1;
        int mod=1000000007;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S')count++;
        }
        if(count==0)return 0;
        if(count%2!=0)return 0;
        int seat=0;
        int plant=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='S'){
                seat++;
                if(seat>2){
                    totalWays=(totalWays*(plant+1))%mod;
                    seat=1;
                    plant=0;
                }
            }
            else{
                if(seat==2){
                    plant++;
                }
            }
        }
        return (int)totalWays;
    }
}