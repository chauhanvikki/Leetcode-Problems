class Solution {
    public int numSub(String s) {
        long ans=0;
        long count=0;
        int mod=1000000007;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                count+=1;
                ans=(ans+count)%mod;
            }
            else{
                count=0;
            }
        }
        return (int)ans;
    }
}