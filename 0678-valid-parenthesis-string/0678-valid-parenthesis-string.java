class Solution {
    public boolean checkValidString(String s) {
        int minOpen=0,maxOpen=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                minOpen++;
                maxOpen++;
            }
            else if(ch==')'){
                if(maxOpen<0)return false;
                minOpen--;
                if(minOpen<0)minOpen=0;
                maxOpen--;
                if(maxOpen<0)return false;
            }
            else if(ch=='*'){
                minOpen--;
                minOpen=Math.max(minOpen,0);
                maxOpen++;
            }
        }
        if(minOpen==0)return true;
        return false;

        // Stack<Integer> left=new Stack<>();
        // Stack<Integer> star=new Stack<>();
        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     if(ch=='('){
        //         left.add(i);
        //     }
        //     else if(ch==')'){
        //         if(!left.isEmpty()){
        //             left.pop();
        //         }else if(!star.isEmpty()){
        //             star.pop();
        //         }else{
        //             return false;
        //         }
        //     }
        //     else if(ch=='*'){
        //         star.add(i);
        //     }
        // }
        // while(!left.isEmpty() && !star.isEmpty()){
        //     if(left.peek()<star.peek()){
        //         left.pop();
        //         star.pop();
        //     }
        //     else{
        //         star.pop();
        //     }
        // }
        // if(left.isEmpty())return true;
        // return false;
    }
}
