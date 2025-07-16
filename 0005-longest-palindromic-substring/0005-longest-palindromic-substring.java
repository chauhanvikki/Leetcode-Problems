class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1)return "";
        String nn="";
        for(int i=0;i<s.length();i++){

            String odd=expandLen(i,i,s);
            String even=expandLen(i,i+1,s);
            if(odd.length()>nn.length())nn=odd;
            if(even.length()>nn.length())nn=even;
        }
        return nn;
    }

    public String expandLen(int left,int right,String s){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            return s.substring(left+1,right);
        }
    }














    //         if(i<s.length()-1){
    //                 if(s.charAt(i)==s.charAt(i+1)){
    //                     left=i;
    //                     right=i+1;
    //                     count=2;
    //                     nn=s.substring(left,count);
    //                 }
    //         }
    //         while(left>=0 && right<s.length()){
    //             if(s.charAt(left)==s.charAt(right)){
    //                 if(left==i && right==i ){
    //                     count=1;
    //                 }
    //                 else{
    //                     count+=2;
    //                 }
    //                 if(nn.length()<count){
    //                     nn=s.substring(left,count);
    //                 }   
    //             }
    //             left--;
    //             right++;
    //         }
    //     }
    //     return nn;
    // }
// }