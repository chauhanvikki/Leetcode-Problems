class Solution {
    public String mergeAlternately(String word1, String word2) {
        boolean w1=true;
        boolean w2=false;
        int n=word1.length()+word2.length();
        String s="";
        int j=0;
        int k=0;
        for(int i=0;i<n;i++){
            while(j<word1.length() && w1==true){
                s+=word1.charAt(j);
                w1=false;
                w2=true;
                j++;
            }
            while(k<word2.length() && w2==true){
                s+=word2.charAt(k);
                w2=false;
                w1=true;
                k++;
            }
            while(j<word1.length() && k==word2.length()){
                s+=word1.charAt(j);
                j++;
            }
            while(k<word2.length() && j==word1.length()){
                s+=word2.charAt(k);
                k++;
            }
        }
        return s;
    }
}