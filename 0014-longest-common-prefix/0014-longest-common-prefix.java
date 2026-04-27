class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        if(strs.length==1)return strs[0];
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int index=-1;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                break;
            }
            index++;
        }
        if(index==-1)return "";
        return s1.substring(0,index+1);
    }
}