class Solution {
    public long maximumSumOfHeights(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        long[] right=new long[n];
        long[] left=new long[n];
        long sum=0;
        long max=0;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                sum=(i+1)*(long)heights[i];
            }
            else{
                int prev=st.peek();
                sum=left[prev]+ (long)heights[i]*(i-prev);
            }
            left[i]=sum;
            st.push(i);
        }
        st.clear();
        sum=0;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                sum=(n-i)*(long)heights[i];
            }
            else{
                int prev=st.peek();
                sum=right[prev]+ (long)heights[i]*(prev-i);
            }
            right[i]=sum;
            st.push(i);
        }
        for(int i=0;i<n;i++){
            max=Math.max(max,(right[i]+left[i])-(long)heights[i]);
        }
        return max;
    }
}