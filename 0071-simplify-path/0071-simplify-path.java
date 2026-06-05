class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] parts=path.split("/");
        for(String s:parts){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s);
            }
        }
        if(st.isEmpty())return "/";
        StringBuilder sb=new StringBuilder();
        for(String s:st){
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }
}