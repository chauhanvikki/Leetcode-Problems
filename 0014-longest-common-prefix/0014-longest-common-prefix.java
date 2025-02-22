class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1=strs[0];
        String str2=strs[strs.length-1];
        int m=Math.min(str1.length(),str2.length());
        if(str1.isEmpty()){
            return "";
        }
        int count=0;
        for(int i=0;i<m;i++){
            if(str1.charAt(i)==str2.charAt(i)){
                count++;
            }
            else{
                break;
            }
        }
        return str1.substring(0,count);
    }
}