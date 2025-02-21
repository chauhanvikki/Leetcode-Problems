class Solution {
    public int reverse(int x) {
        // int temp=x;
        int sum=0;
        //  if(x<0){
        //         x=x*-1;
        //     }
        while(x!=0){
            // int digits=(int)Math.log10(x);
            int remainder=x%10;
             if (sum > Integer.MAX_VALUE / 10 || sum < Integer.MIN_VALUE /  10) {
    return 0;
}
            sum=sum * 10+remainder;
            x=x/10;
        }
        // if(temp<0){
        //     return -sum;
        // }
//         if (sum > Integer.MAX_VALUE / 10 || sum < Integer.MIN_VALUE /  10) {
//     return 0;
// }

        return sum;
    }
}