class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st=new Stack<>();
        st.push(directions.charAt(0));
        int coll=0;
        int i=1;
        int prev=0;
        while(i<directions.length()){
            char ch=directions.charAt(i);
            if(ch=='L'){
                if(!st.isEmpty() && st.peek()=='R'){
                        coll=coll+2;
                        st.pop();
                        ch='S';
                        while(!st.isEmpty() && st.peek()=='R'){
                            coll=coll+1;
                            st.pop();
                        }
                    }
                if(!st.isEmpty() && ch=='L' && st.peek()=='S'){
                        coll++;
                        ch='S';
                    }
                    st.push('S');
                    i++;
                    continue;
                }
            else if(ch=='S' ){
                if(!st.isEmpty() && st.peek()=='R'){
                    coll++;
                    st.pop();
                }
                st.push('S');
                i++;
                continue;
            }
            else{
                st.push('R');
                i++;
                continue;
            }
        }
        return coll;
    }
}