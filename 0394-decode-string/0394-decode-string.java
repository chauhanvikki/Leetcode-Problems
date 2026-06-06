class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack=new Stack<>();
        Stack<String> countString=new Stack<>();
        String currString="";
        int currNum=0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                currNum=currNum*10+(ch-'0');
            }
            else if(ch=='['){
                countStack.push(currNum);
                countString.push(currString);
                currNum=0;
                currString="";
            }
            else if(ch==']'){
                int repeat=countStack.pop();
                String previous=countString.pop();
                StringBuilder sb=new StringBuilder(previous);
                for(int i=0;i<repeat;i++){
                    sb.append(currString);
                }
                currString=sb.toString();
            }
            else{
                currString+=ch;
            }
        }
        return currString;
    }
}