class Solution {
    public int addDigits(int num) {
        int temp=num;
        while(temp>=10){
            int sum=0;
            while(temp!=0){
                int remainder=temp%10;
                sum=sum+remainder;
                temp=temp/10;
            }
            temp=sum;
        }
        return temp;
    }
}