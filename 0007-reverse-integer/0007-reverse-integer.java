class Solution {
    public int reverse(int x) {
        int sum=0;
        while(x!=0){
            int remainder=x%10;
             if (sum > Integer.MAX_VALUE / 10 || sum <Integer.         MIN_VALUE /  10) {
                return 0;
            }
            sum=sum * 10+remainder;
            x=x/10;
        }
        return sum;
    }
}