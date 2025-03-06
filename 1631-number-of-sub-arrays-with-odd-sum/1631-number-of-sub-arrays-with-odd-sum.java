class Solution {
    public int numOfSubarrays(int[] arr) {
        long MOD=1000000007;
        long es=1;
        long os=0;
        long res=0;
        long pre=0;
        for(int i=0;i<arr.length;i++){
            pre+=arr[i];
            if(pre%2==1){
                res+=es%MOD;
                os++;
            }
            else{
                res+=os%MOD;
                es++;
            }
        }
        res=res%MOD;
        return (int)res;
    }
}