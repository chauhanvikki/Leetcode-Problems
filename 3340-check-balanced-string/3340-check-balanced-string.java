class Solution {
    public boolean isBalanced(String num) {
        int i=0;
        int j=1;
        int a=0;
        int b=0;
        while(i<num.length()){
            a+=num.charAt(i)-'0';
            i=i+2;
        }
        while(j<num.length()){
            b+=num.charAt(j)-'0';
            j=j+2;
        }
        return a==b;
    }
}