class Solution {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        int mod=1000000007;
        long count=1;
        for(int i=1;i<n;i++){
            if(complexity[0]>=complexity[i]){
                return 0;
            }
        }
        for(int i=1;i<n;i++){
            count=(count*(long)(n-i))%mod;
        }
        return (int)count;
    }
}