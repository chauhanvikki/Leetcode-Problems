class Solution {
    public String multiply(String num1, String num2) {
        char[] a=reverse(num1);
        char[] b=reverse(num2);
        int res[]=new int[a.length+b.length];
        for(int i=0;i<a.length;i++){
            int carry=0;
            int start=i;
            for(int j=0;j<b.length;j++){
                int n1=a[i]-'0';
                int n2=b[j]-'0';
                int sum=(n1*n2)+res[start]+(carry);
                int base=sum%10;
                carry=sum/10;
                res[start++]=base;
            }
            if(carry!=0)res[start]+=carry;
        }
            String ans="";
            int i=res.length-1;
            while(i>0 && res[i]==0)i--;
            while(i>=0){
                ans+=res[i--];
            }
            return ans;
        }
    public char[] reverse(String num){
        char[] ans=num.toCharArray();
        int start=0,end=num.length()-1;
        while(start<end){
            char temp=ans[start];
            ans[start]=ans[end];
            ans[end]=temp;
            start++;
            end--;
        }
        return ans;
    }
}
