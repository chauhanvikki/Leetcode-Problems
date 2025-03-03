class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs=new HashSet<>();
        while(!hs.contains(n) && n!=1){
            hs.add(n);
            n=reverse(n);
        }
        return n==1;
    }
    public static int reverse(int n){
        int sum=0;
        while(n>0){
            int digits=n%10;
            sum+=digits*digits;
            n=n/10;
        }
        return sum;
    }
}