class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(s.length()>i){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                st.add(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                if(s.charAt(i)==')' && st.peek()=='(' || s.charAt(i)=='}' && st.peek()=='{' || s.charAt(i)==']' && st.peek()=='['){
                st.pop();
                }
                else{
                    return false;
                }
                }
                i++;
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}