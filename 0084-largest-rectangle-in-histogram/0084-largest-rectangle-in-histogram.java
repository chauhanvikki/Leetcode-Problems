class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] right=new int[n];
        int[] left=new int[n];
        int max=0;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=n;
            }
            else{
                right[i]=st.peek();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=-1;
            }
            else{
                left[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            int area=heights[i]*width;
            max=Math.max(area,max);
        }
        return max;
    }
}