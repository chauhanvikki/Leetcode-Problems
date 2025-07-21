class Solution {
    public String makeFancyString(String s) {
        String str="";
        for(int i=0;i<s.length();i++){
            if(i-1>=0 && i+1<s.length() && s.charAt(i)==s.charAt(i-1) && s.charAt(i+1)==s.charAt(i)){
                continue;
            }
            else{
                str+=s.charAt(i);
            }
        }
        return str;
    }
}