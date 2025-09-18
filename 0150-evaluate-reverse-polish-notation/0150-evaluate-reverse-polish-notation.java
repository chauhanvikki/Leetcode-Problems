class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        if(tokens.length!=0)st.add(Integer.parseInt(tokens[0]));
        int ans=st.peek();
        for(int i=1;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int a=st.peek();
                st.pop();
                int b=st.peek();
                st.pop();
                st.push(a+b);
            }
            else if(tokens[i].equals("-")){
                int a=st.peek();
                st.pop();
                int b=st.peek();
                st.pop();
                st.push(b-a);
            }
            else if(tokens[i].equals("*")){
                int a=st.peek();
                st.pop();
                int b=st.peek();
                st.pop();
                st.push(a*b);
            }
            else if(tokens[i].equals("/")){
                int a=st.peek();
                st.pop();
                int b=st.peek();
                st.pop();
                st.push(b/a);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}
