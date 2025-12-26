class Solution {
    public int bestClosingTime(String customers) {
        int count=0;
        int mini=Integer.MAX_VALUE;
        int ans=0;
        int nc=0;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y')count++;
        }
        if(count==0)return 0;
        mini=count;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y')count--;
            else{
                count++;
            }
            if(mini>count){
                ans=i+1;
                mini=count;
            }
        }
        return ans;
    }
}