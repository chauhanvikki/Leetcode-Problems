class Solution {  //Histogram+largest rectangle
    public int maximalRectangle(char[][] matrix) {
        int[][] grid=new int[matrix.length][matrix[0].length];
        int maxA=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    grid[i][j]=0;
                }
                else{
                    if(i>0){
                        grid[i][j]=grid[i-1][j]+1;
                    }
                    else{
                        grid[i][j]=1;
                    }
                }
            }
            maxA=Math.max(solve(grid[i]),maxA);
        }
        return maxA;
    }
    public int solve(int[] arr){
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
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
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
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
        int maxA=0;
        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            maxA=Math.max(maxA,arr[i]*width);
        }
        return maxA;
    }
}