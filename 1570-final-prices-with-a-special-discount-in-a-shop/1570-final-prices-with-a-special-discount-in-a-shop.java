class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        ans[n-1]=prices[n-1];
        st.push(prices[n-1]);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && prices[i]<st.peek()){
                st.pop();
            }
            if(!st.isEmpty() && prices[i]>=st.peek()){
                ans[i]=prices[i]-st.peek();
            }
            else{
                ans[i]=prices[i];
            }
            st.push(prices[i]);
        }
        return ans;
    }
}